package ny.times.reader.routes.home

import ny.times.reader.navigator.home.HomeNavigation
import ny.times.reader.navigator.home.HomeRoutes
import ny.times.reader.routes.base.NavigationManager
import javax.inject.Inject

class HomeNavigationImpl @Inject constructor(
    private val navigationManager: NavigationManager
) : HomeNavigation {

    override fun switchToFeed() = navigationManager.navigateTo(HomeRoutes.Feed)

    override fun switchToSearch() = navigationManager.navigateTo(HomeRoutes.Search)

    override fun switchToBookmarks() = navigationManager.navigateTo(HomeRoutes.Bookmarks)

}