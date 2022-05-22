package ny.times.reader.navigator.base

import androidx.navigation.NamedNavArgument

abstract class RouteParams {
    abstract val arguments: List<NamedNavArgument>
    abstract val route: String
}