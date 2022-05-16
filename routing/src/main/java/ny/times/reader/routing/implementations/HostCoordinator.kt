package ny.times.reader.routing.implementations

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ny.times.reader.home.presentation.HomeFragment
import ny.times.reader.navigation.HostNavigator
import javax.inject.Inject

class HostCoordinator @Inject constructor(private val router: Router) : HostNavigator {

    override fun goToHome() = router.newRootScreen(
        FragmentScreen(
            key = HomeFragment::class.java.simpleName,
            fragmentCreator = { HomeFragment() }
        )
    )

}