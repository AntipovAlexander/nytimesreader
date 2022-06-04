package ny.times.reader.navigator.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter

interface BaseRouter {
    val commands: Flow<NavigationCommand>
}

inline fun <reified T : Destination> Flow<NavigationCommand>.filterIsInstance() =
    filter { command ->
        when (command) {
            is NavigationCommand.Back -> command.destination == null || command.destination is T
            is NavigationCommand.Forward -> command.destination is T
        }
    }