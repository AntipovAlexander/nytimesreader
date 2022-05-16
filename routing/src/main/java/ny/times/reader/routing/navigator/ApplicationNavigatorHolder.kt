package ny.times.reader.routing.navigator

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class ApplicationNavigatorHolder @Inject constructor(cicerone: Cicerone<Router>) {

    private val navHolder = cicerone.getNavigatorHolder()

    fun removeNavigator() {
        navHolder.removeNavigator()
    }

    fun setNavigator(navigator: ApplicationNavigator) {
        navHolder.setNavigator(navigator)
    }
}
