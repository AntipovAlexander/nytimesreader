package ny.times.reader.search.presentation

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ny.times.reader.base.presentation.BaseFragment
import ny.times.reader.search.presentation.ui.SearchUi

@AndroidEntryPoint
class SearchFragment : BaseFragment() {

    private val searchViewModel by viewModels<SearchViewModel>()

    @Composable
    override fun Content() = SearchUi(
        searchText = searchViewModel.state.searchQuery,
        contentState = searchViewModel.state.contentState,
        onSearchChanged = searchViewModel::searchQueryChanged,
        onRetryClick = searchViewModel::retrySearch
    )
}