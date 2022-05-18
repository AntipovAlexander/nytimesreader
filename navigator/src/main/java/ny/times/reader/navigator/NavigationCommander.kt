package ny.times.reader.navigator

interface NavigationCommander {
    fun navigateTo(navigationCommand: NavigationCommand)
}