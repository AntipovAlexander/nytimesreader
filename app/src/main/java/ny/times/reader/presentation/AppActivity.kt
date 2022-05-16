package ny.times.reader.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import ny.times.reader.R
import ny.times.reader.base.presentation.BaseFragment
import ny.times.reader.routing.navigator.ApplicationNavigator
import ny.times.reader.routing.navigator.ApplicationNavigatorHolder
import javax.inject.Inject

@AndroidEntryPoint
class AppActivity : FragmentActivity(R.layout.app_activity) {

    @Inject
    lateinit var navigator: ApplicationNavigator

    @Inject
    lateinit var navigatorHolder: ApplicationNavigatorHolder

    private val currentFragment: BaseFragment?
        get() = supportFragmentManager.findFragmentById(R.id.container) as? BaseFragment

    private val appViewModel by viewModels<AppViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appViewModel.navigate()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        currentFragment?.onBackPressed() ?: super.onBackPressed()
    }

}
