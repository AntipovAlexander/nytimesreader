package ny.times.reader.routes.app

import ny.times.reader.navigator.app.AppRouter
import ny.times.reader.navigator.app.AppRoutes
import ny.times.reader.navigator.base.filterIsInstance
import ny.times.reader.routes.base.NavigationManager
import javax.inject.Inject

class AppRouterImpl @Inject constructor(
    navigationManager: NavigationManager
) : AppRouter {
    override val commands = navigationManager.commands.filterIsInstance<AppRoutes>()
}