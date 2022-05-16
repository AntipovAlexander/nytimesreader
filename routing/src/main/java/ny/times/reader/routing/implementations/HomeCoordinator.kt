package ny.times.reader.routing.implementations

import ny.times.reader.navigation.ExitNavigator
import ny.times.reader.navigation.HomeNavigator
import javax.inject.Inject

class HomeCoordinator @Inject constructor(
    private val exitCoordinator: ExitCoordinator
) : HomeNavigator, ExitNavigator by exitCoordinator