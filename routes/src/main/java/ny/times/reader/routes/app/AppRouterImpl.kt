package ny.times.reader.routes.app

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterIsInstance
import ny.times.reader.navigator.app.AppRouter
import ny.times.reader.navigator.app.AppRoutes
import ny.times.reader.routes.base.NavigationManager
import javax.inject.Inject

class AppRouterImpl @Inject constructor(navigationManager: NavigationManager) :
    AppRouter {
    override val appRoutes: Flow<AppRoutes> = navigationManager.commands.filterIsInstance()
}