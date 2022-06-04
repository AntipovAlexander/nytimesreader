package ny.times.reader.home.presentation.ui

import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import ny.times.reader.navigator.home_tabs.HomeTabsRouter

suspend fun NavController.attachRouter(router: HomeTabsRouter) {
    router
        .commands
        .onEach { command ->
            val route = command.destination?.route ?: return@onEach
            navigate(route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(graph.findStartDestination().id) { saveState = true }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        }.collect()
}