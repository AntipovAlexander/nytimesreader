package ny.times.reader.home.presentation

import dagger.hilt.android.lifecycle.HiltViewModel
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.base.presentation.view_model.BaseViewState
import ny.times.reader.home.navigation.BottomTabs
import ny.times.reader.navigator.home_tabs.HomeTabsNavigation
import ny.times.reader.navigator.home_tabs.HomeTabsRouter
import javax.inject.Inject

@HiltViewModel
class HomeTabsViewModel @Inject constructor(
    private val homeTabsNavigation: HomeTabsNavigation,
    private val homeTabsRouter: HomeTabsRouter
) : BaseViewModel<HomeTabsViewModel.HomeViewState>(HomeViewState),
    HomeTabsRouter by homeTabsRouter {

    override fun onReduceState(viewAction: BaseViewAction): HomeViewState = state

    fun onTabSwitched(tab: BottomTabs) {
        when (tab) {
            BottomTabs.Feed -> homeTabsNavigation.switchToFeed()
            BottomTabs.Search -> homeTabsNavigation.switchToSearch()
            BottomTabs.Bookmarks -> homeTabsNavigation.switchToBookmarks()
        }
    }

    object HomeViewState : BaseViewState
}