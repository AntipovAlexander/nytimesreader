package ny.times.reader.home.presentation

import androidx.compose.runtime.Composable
import ny.times.reader.base.presentation.BaseFragment
import ny.times.reader.home.presentation.ui.Home

class HomeFragment : BaseFragment() {

    @Composable
    override fun Content() {
        Home(fragmentManager = childFragmentManager, lifecycle = lifecycle)
    }

}