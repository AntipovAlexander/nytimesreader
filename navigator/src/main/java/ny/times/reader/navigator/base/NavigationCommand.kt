package ny.times.reader.navigator.base

sealed class NavigationCommand(open val destination: Destination?) {
    data class Back(override val destination: Destination?) : NavigationCommand(destination)
    data class Forward(override val destination: Destination) : NavigationCommand(destination)
}
