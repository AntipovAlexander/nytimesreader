package ny.times.reader.navigator

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationManager @Inject constructor() : NavigationObserver, NavigationCommander {

    private val _commands = MutableStateFlow<NavigationCommand?>(null)

    override val commands: Flow<NavigationCommand> = _commands.filterNotNull()

    override fun navigateTo(navigationCommand: NavigationCommand) {
        _commands.value = navigationCommand
    }
}