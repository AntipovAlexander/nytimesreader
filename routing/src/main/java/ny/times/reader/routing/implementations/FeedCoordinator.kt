package ny.times.reader.routing.implementations

import com.github.terrakok.cicerone.Router
import ny.times.reader.navigation.FeedNavigator
import javax.inject.Inject

class FeedCoordinator @Inject constructor(private val router: Router) : FeedNavigator {

    override fun goToNewsDetails() {
        TODO("Not yet implemented")
    }

}