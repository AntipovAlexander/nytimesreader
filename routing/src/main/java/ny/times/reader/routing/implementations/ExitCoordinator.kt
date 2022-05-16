package ny.times.reader.routing.implementations

import com.github.terrakok.cicerone.Router
import ny.times.reader.navigation.ExitNavigator
import javax.inject.Inject

class ExitCoordinator @Inject constructor(private val router: Router) : ExitNavigator {
    override fun exit() = router.exit()
}