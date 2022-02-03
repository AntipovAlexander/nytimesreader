package ny.times.reader.search.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ny.times.reader.base.presentation.ui.news.NewsContent
import ny.times.reader.base.presentation.ui.widget.EnterAlwaysScaffold
import ny.times.reader.base.presentation.ui.widget.SearchBar
import ny.times.reader.base.presentation.ui.widget.Toolbar
import ny.times.reader.search.R

@Composable
fun Search(searchVm: SearchViewModel = hiltViewModel()) {
    EnterAlwaysScaffold(
        toolbar = { scaffoldModifier ->
            Toolbar(
                modifier = scaffoldModifier,
                text = stringResource(R.string.search)
            )
        },
        enterAlwaysBar = { scaffoldModifier ->
            SearchBar(
                text = searchVm.state.searchQuery,
                modifier = scaffoldModifier.then(Modifier.padding(all = 16.dp)),
                onTextChanged = searchVm::searchQueryChanged
            )
        },
        scrollableContent = { scaffoldModifier ->
            NewsContent(
                modifier = scaffoldModifier,
                state = searchVm.state.contentState,
                onRetryClicked = searchVm::retrySearch
            )
        })
}

@Preview
@Composable
fun SearchPreview() {
    Search()
}