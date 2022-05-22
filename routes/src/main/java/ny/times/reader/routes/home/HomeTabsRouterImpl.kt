package ny.times.reader.routes.home

import kotlinx.coroutines.flow.filterIsInstance
import ny.times.reader.navigator.home_tabs.HomeTabsRouter
import ny.times.reader.navigator.home_tabs.HomeTabsRoutes
import ny.times.reader.routes.base.NavigationManager
import javax.inject.Inject

class HomeTabsRouterImpl @Inject constructor(
    navigationManager: NavigationManager
) : HomeTabsRouter {
    override val tabsRoutes = navigationManager.destinations.filterIsInstance<HomeTabsRoutes>()
}