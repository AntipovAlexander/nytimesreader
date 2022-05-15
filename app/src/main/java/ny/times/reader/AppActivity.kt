package ny.times.reader

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import ny.times.reader.home.presentation.HomeFragment

@AndroidEntryPoint
class AppActivity : FragmentActivity(R.layout.app_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, HomeFragment())
            .commit()
    }
}
