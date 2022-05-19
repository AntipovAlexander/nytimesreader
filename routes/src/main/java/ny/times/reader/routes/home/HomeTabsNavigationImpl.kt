package ny.times.reader.routes.home

import ny.times.reader.navigator.home_tabs.HomeTabsNavigation
import ny.times.reader.navigator.home_tabs.HomeTabsRoutes
import ny.times.reader.routes.base.NavigationManager
import javax.inject.Inject

class HomeTabsNavigationImpl @Inject constructor(
    private val navigationManager: NavigationManager
) : HomeTabsNavigation {

    override fun switchToFeed() = navigationManager.navigateTo(HomeTabsRoutes.Feed)

    override fun switchToSearch() = navigationManager.navigateTo(HomeTabsRoutes.Search)

    override fun switchToBookmarks() = navigationManager.navigateTo(HomeTabsRoutes.Bookmarks)

}