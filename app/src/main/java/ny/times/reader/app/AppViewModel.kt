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
    val router: AppRouter,
    private val navigation: AppNavigation,
) : BaseViewModel<AppViewModel.HomeViewState>(HomeViewState) {

    override fun onReduceState(viewAction: BaseViewAction): HomeViewState = state

    fun onBackPressed() = navigation.navigateBack()

    object HomeViewState : BaseViewState
}