package ny.times.reader.navigator.home

import androidx.navigation.NamedNavArgument
import ny.times.reader.navigator.base.NavigationCommand

sealed class HomeRoutes : NavigationCommand {

    object Feed : HomeRoutes() {
        override val arguments = emptyList<NamedNavArgument>()
        override val route = "feed_route"
    }

    object Search : HomeRoutes() {
        override val arguments = emptyList<NamedNavArgument>()
        override val route = "search_route"
    }

    object Bookmarks : HomeRoutes() {
        override val arguments = emptyList<NamedNavArgument>()
        override val route = "bookmarks_route"
    }

}