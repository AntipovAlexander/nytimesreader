package ny.times.reader.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.navigation.HostNavigator
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val hostNavigator: HostNavigator
) : BaseViewModel<AppViewState>(AppViewState.Initial) {

    override fun onReduceState(viewAction: BaseViewAction): AppViewState = state

    fun navigate() = hostNavigator.goToHome()

}