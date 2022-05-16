package ny.times.reader.routing.implementations

import ny.times.reader.navigation.ExitNavigator
import ny.times.reader.navigation.NewsDetailsNavigator
import javax.inject.Inject

class NewsDetailsCoordinator @Inject constructor(
    private val exitCoordinator: ExitCoordinator
) : NewsDetailsNavigator, ExitNavigator by exitCoordinator