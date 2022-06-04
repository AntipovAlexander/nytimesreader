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
    val router: HomeTabsRouter,
    private val navigator: HomeTabsNavigation
) : BaseViewModel<HomeTabsViewModel.HomeViewState>(HomeViewState) {

    override fun onReduceState(viewAction: BaseViewAction): HomeViewState = state

    fun onTabSwitched(tab: BottomTabs) {
        when (tab) {
            BottomTabs.Feed -> navigator.switchToFeed()
            BottomTabs.Search -> navigator.switchToSearch()
            BottomTabs.Bookmarks -> navigator.switchToBookmarks()
        }
    }

    object HomeViewState : BaseViewState
}