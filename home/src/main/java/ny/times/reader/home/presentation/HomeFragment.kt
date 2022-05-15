package ny.times.reader.home.presentation

import androidx.compose.runtime.Composable
import dagger.hilt.android.AndroidEntryPoint
import ny.times.reader.base.presentation.BaseFragment
import ny.times.reader.home.presentation.ui.Home

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    @Composable
    override fun Content() = Home(childFragmentManager, lifecycle)

}