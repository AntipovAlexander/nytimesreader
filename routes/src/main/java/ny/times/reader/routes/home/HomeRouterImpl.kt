package ny.times.reader.routes.home

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import ny.times.reader.navigator.home.HomeRouter
import ny.times.reader.navigator.home.HomeRoutes
import ny.times.reader.routes.base.NavigationManager
import javax.inject.Inject

class HomeRouterImpl @Inject constructor(navigationManager: NavigationManager) : HomeRouter {
    override val routes: Flow<HomeRoutes> = navigationManager.commands.filterIsInstance()
}