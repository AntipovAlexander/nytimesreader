package ny.times.reader.routing.navigator

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ny.times.reader.routing.R
import javax.inject.Inject

/**
 * Put here your new implementation of AppNavigator, if it needed
 */
class ApplicationNavigator @Inject constructor(
    activity: FragmentActivity,
    @IdRes private val container: Int,
    fragmentManager: FragmentManager = activity.supportFragmentManager
) : AppNavigator(activity, container, fragmentManager) {

    override fun setupFragmentTransaction(
        screen: FragmentScreen,
        fragmentTransaction: FragmentTransaction,
        currentFragment: Fragment?,
        nextFragment: Fragment
    ) {
        fragmentTransaction.setCustomAnimations(
            R.anim.slide_from_right,
            R.anim.slide_to_left,
            R.anim.slide_from_left,
            R.anim.slide_to_right
        )
        super.setupFragmentTransaction(screen, fragmentTransaction, currentFragment, nextFragment)
    }

}
