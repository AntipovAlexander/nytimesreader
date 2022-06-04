package ny.times.reader.routes.home

import ny.times.reader.navigator.base.NavigationCommand
import ny.times.reader.navigator.home_tabs.HomeTabsNavigation
import ny.times.reader.navigator.home_tabs.HomeTabsRoutes
import ny.times.reader.routes.base.NavigationManager
import javax.inject.Inject

class HomeTabsNavigationImpl @Inject constructor(
    private val navigationManager: NavigationManager
) : HomeTabsNavigation {

    override fun switchToFeed() {
        val command = NavigationCommand.Forward(HomeTabsRoutes.Feed())
        navigationManager.apply(command)
    }

    override fun switchToSearch() {
        val command = NavigationCommand.Forward(HomeTabsRoutes.Search())
        navigationManager.apply(command)
    }

    override fun switchToBookmarks() {
        val commands = NavigationCommand.Forward(HomeTabsRoutes.Bookmarks())
        navigationManager.apply(commands)
    }

}