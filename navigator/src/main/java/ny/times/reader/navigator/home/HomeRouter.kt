package ny.times.reader.navigator.home

import kotlinx.coroutines.flow.Flow

interface HomeRouter {
    val routes: Flow<HomeRoutes>
}