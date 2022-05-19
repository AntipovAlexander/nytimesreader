package ny.times.reader.navigator.home_tabs

import kotlinx.coroutines.flow.Flow

interface HomeTabsRouter {
    val tabsRoutes: Flow<HomeTabsRoutes>
}