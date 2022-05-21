package ny.times.reader.navigator.app

import androidx.navigation.NamedNavArgument
import ny.times.reader.navigator.base.NavigationCommand

sealed class AppRoutes : NavigationCommand() {

    object Back : AppRoutes() {
        override val arguments = emptyList<NamedNavArgument>()
        override val route = ""
    }

    object HomeTabs : AppRoutes() {
        override val arguments = emptyList<NamedNavArgument>()
        override val route = "home"
    }

    object NewsDetails : AppRoutes() {
        override val arguments = emptyList<NamedNavArgument>()
        override val route = "search_route"
    }

}