package ny.times.reader.navigator.home_tabs

import androidx.navigation.NamedNavArgument
import ny.times.reader.navigator.base.NavigationCommand

sealed class HomeTabsRoutes : NavigationCommand() {

    object Feed : HomeTabsRoutes() {
        override val arguments = emptyList<NamedNavArgument>()
        override val route = "feed_route"
    }

    object Search : HomeTabsRoutes() {
        override val arguments = emptyList<NamedNavArgument>()
        override val route = "search_route"
    }

    object Bookmarks : HomeTabsRoutes() {
        override val arguments = emptyList<NamedNavArgument>()
        override val route = "bookmarks_route"
    }

}