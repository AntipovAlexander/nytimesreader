package ny.times.reader.home.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.navigation.HomeNavigator
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeNavigator: HomeNavigator
) : BaseViewModel<HomeViewState>(HomeViewState.Initial) {

    override fun onReduceState(viewAction: BaseViewAction): HomeViewState = state

    override fun onBackPressed() = homeNavigator.exit()

}