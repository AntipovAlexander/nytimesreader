package ny.times.reader.navigator.home_tabs

import androidx.navigation.NamedNavArgument
import ny.times.reader.navigator.base.Destination
import ny.times.reader.navigator.base.RouteParams

sealed class HomeTabsRoutes : Destination() {

    class Feed : HomeTabsRoutes() {

        companion object : RouteParams() {
            override val arguments = emptyList<NamedNavArgument>()
            override val route = "feed_route"
        }

        override val destination: String = route
    }

    class Search : HomeTabsRoutes() {

        companion object : RouteParams() {
            override val arguments = emptyList<NamedNavArgument>()
            override val route = "search_route"
        }

        override val destination: String = route
    }

    class Bookmarks : HomeTabsRoutes() {

        companion object : RouteParams() {
            override val arguments = emptyList<NamedNavArgument>()
            override val route = "bookmarks_route"
        }

        override val destination: String = route
    }

}