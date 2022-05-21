package ny.times.reader.app

import dagger.hilt.android.lifecycle.HiltViewModel
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.base.presentation.view_model.BaseViewState
import ny.times.reader.navigator.app.AppNavigation
import ny.times.reader.navigator.app.AppRouter
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val appNavigation: AppNavigation,
    private val appRouter: AppRouter
) : BaseViewModel<AppViewModel.HomeViewState>(HomeViewState),
    AppRouter by appRouter,
    AppNavigation by appNavigation {

    override fun onReduceState(viewAction: BaseViewAction): HomeViewState = state

    object HomeViewState : BaseViewState
}