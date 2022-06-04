package ny.times.reader.routes.home

import ny.times.reader.navigator.base.filterIsInstance
import ny.times.reader.navigator.home_tabs.HomeTabsRouter
import ny.times.reader.navigator.home_tabs.HomeTabsRoutes
import ny.times.reader.routes.base.NavigationManager
import javax.inject.Inject

class HomeTabsRouterImpl @Inject constructor(
    navigationManager: NavigationManager
) : HomeTabsRouter {
    override val commands = navigationManager.commands.filterIsInstance<HomeTabsRoutes>()
}