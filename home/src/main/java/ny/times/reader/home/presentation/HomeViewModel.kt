package ny.times.reader.home.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.home.navigation.BottomTabs
import ny.times.reader.navigator.home.HomeNavigation
import ny.times.reader.navigator.home.HomeRouter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeNavigation: HomeNavigation,
    private val homeRouter: HomeRouter
) : BaseViewModel<HomeViewState>(HomeViewState.INITIAL), HomeRouter by homeRouter {

    override fun onReduceState(viewAction: BaseViewAction): HomeViewState = when (viewAction) {
        is HomeViewActions.ChangeCurrentRoute -> state.copy(currentRoute = viewAction.route)
        else -> state
    }

    fun onTabSwitched(tab: BottomTabs) {
        when (tab) {
            BottomTabs.Feed -> homeNavigation.switchToFeed()
            BottomTabs.Search -> homeNavigation.switchToSearch()
            BottomTabs.Bookmarks -> homeNavigation.switchToBookmarks()
        }
    }
}