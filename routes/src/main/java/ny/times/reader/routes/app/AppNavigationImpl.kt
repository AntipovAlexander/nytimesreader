package ny.times.reader.routes.app

import ny.times.reader.navigator.app.AppNavigation
import ny.times.reader.navigator.app.AppRoutes
import ny.times.reader.routes.base.NavigationManager
import javax.inject.Inject

class AppNavigationImpl @Inject constructor(
    private val navigationManager: NavigationManager
) : AppNavigation {
    override fun navigateBack() = navigationManager.navigateTo(AppRoutes.Back)
}