package ny.times.reader.home.presentation

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ny.times.reader.base.presentation.BaseFragment
import ny.times.reader.home.presentation.ui.Home

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    private val homeViewModel by viewModels<HomeViewModel>()

    @Composable
    override fun Content() = Home(childFragmentManager, lifecycle)

    override fun onBackPressed() = homeViewModel.onBackPressed()

}