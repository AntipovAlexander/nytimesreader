package ny.times.reader.navigator.base

import androidx.navigation.NamedNavArgument

abstract class NavigationCommand {
    abstract val arguments: List<NamedNavArgument>
    abstract val route: String

    final override fun equals(other: Any?) = false

    final override fun hashCode(): Int {
        var result = arguments.hashCode()
        result = 31 * result + route.hashCode()
        return result
    }
}