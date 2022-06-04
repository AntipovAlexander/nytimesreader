package ny.times.reader.app

import androidx.navigation.NavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import ny.times.reader.navigator.app.AppRouter
import ny.times.reader.navigator.base.NavigationCommand

suspend fun NavController.attachRouter(router: AppRouter) {
    router
        .commands
        .onEach { command ->
            when (command) {
                is NavigationCommand.Back -> popBackStack()
                else -> {
                    val destination = command.destination ?: return@onEach
                    navigate(destination.route)
                }
            }
        }.collect()
}