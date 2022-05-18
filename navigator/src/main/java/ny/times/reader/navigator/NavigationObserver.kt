package ny.times.reader.navigator

import kotlinx.coroutines.flow.Flow

interface NavigationObserver {
    val commands: Flow<NavigationCommand>
}