package ny.times.reader.search.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.presentation.ui.news.NewsContent
import ny.times.reader.base.presentation.ui.widget.EnterAlwaysScaffold
import ny.times.reader.base.presentation.ui.widget.SearchBar
import ny.times.reader.base.presentation.ui.widget.Toolbar
import ny.times.reader.base.theme.TimesReaderTheme
import ny.times.reader.search.R
import ny.times.reader.search.presentation.SearchViewModel
import ny.times.reader.search.presentation.SearchViewState

@Composable
fun SearchUi(
    newsClicked: (News) -> Unit,
    searchVm: SearchViewModel = hiltViewModel(),
) {
    Search(
        searchState = searchVm.state,
        searchQueryChanged = searchVm::searchQueryChanged,
        retryClicked = searchVm::retrySearch,
        itemClicked = { id ->
            val newsItem = searchVm.getById(id) ?: return@Search
            newsClicked(newsItem)
        }
    )
}

@Composable
internal fun Search(
    searchState: SearchViewState,
    itemClicked: (id: String) -> Unit,
    searchQueryChanged: (query: String) -> Unit,
    retryClicked: () -> Unit,
) {
    EnterAlwaysScaffold(
        toolbar = { scaffoldModifier ->
            Toolbar(
                modifier = scaffoldModifier,
                text = stringResource(R.string.search)
            )
        },
        enterAlwaysBar = { scaffoldModifier ->
            SearchBar(
                text = searchState.searchQuery,
                modifier = scaffoldModifier.then(
                    Modifier
                        .background(TimesReaderTheme.colors.white)
                        .padding(all = 16.dp)
                ),
                onTextChanged = searchQueryChanged
            )
        },
        scrollableContent = { scaffoldModifier ->
            NewsContent(
                itemClick = itemClicked,
                modifier = scaffoldModifier,
                state = searchState.contentState,
                onRetryClicked = retryClicked
            )
        })
}

@Preview
@Composable
private fun SearchPreview() {
    Search(
        searchState = PreviewData.get(),
        itemClicked = {},
        searchQueryChanged = {},
        retryClicked = {}
    )
}