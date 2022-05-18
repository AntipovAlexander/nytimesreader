package ny.times.reader.routes.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import ny.times.reader.navigator.base.NavigationCommand
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationManager @Inject constructor() {

    private val _commands = MutableStateFlow<NavigationCommand?>(null)

    val commands: Flow<NavigationCommand> = _commands.filterNotNull()

    fun navigateTo(navigationCommand: NavigationCommand) {
        _commands.value = navigationCommand
    }
}