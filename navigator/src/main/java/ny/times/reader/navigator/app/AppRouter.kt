package ny.times.reader.navigator.app

import kotlinx.coroutines.flow.Flow

interface AppRouter {
    val appRoutes: Flow<AppRoutes>
}