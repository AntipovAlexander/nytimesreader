package ny.times.reader.search.presentation

import androidx.compose.runtime.Composable
import ny.times.reader.base.presentation.BaseFragment

class SearchFragment : BaseFragment() {

    @Composable
    override fun Content() {
        Search()
    }
}