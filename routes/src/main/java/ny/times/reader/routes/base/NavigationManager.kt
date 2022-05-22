package ny.times.reader.routes.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import ny.times.reader.navigator.base.Destination
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationManager @Inject constructor() {

    private val _destinations = MutableStateFlow<Destination?>(null)

    val destinations: Flow<Destination> = _destinations.filterNotNull()

    fun navigateTo(destination: Destination) {
        _destinations.value = destination
    }
}