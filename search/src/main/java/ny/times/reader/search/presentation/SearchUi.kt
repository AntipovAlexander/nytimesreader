package ny.times.reader.search.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.ui.news.NewsContent
import ny.times.reader.base.presentation.ui.widget.EnterAlwaysScaffold
import ny.times.reader.base.presentation.ui.widget.SearchBar
import ny.times.reader.base.presentation.ui.widget.Toolbar
import ny.times.reader.base.theme.TimesReaderTheme
import ny.times.reader.search.R

@Composable
fun Search() {
    EnterAlwaysScaffold(
        toolbar = { scaffoldModifier ->
            Toolbar(
                modifier = scaffoldModifier,
                text = stringResource(R.string.search)
            )
        },
        enterAlwaysBar = { scaffoldModifier ->
            SearchBar(
                // todo
                text = "test text",
//                text = searchVm.state.searchQuery,
                modifier = scaffoldModifier.then(
                    Modifier
                        .background(TimesReaderTheme.colors.white)
                        .padding(all = 16.dp)
                ),
                onTextChanged = {}
//                onTextChanged = searchVm::searchQueryChanged
            )
        },
        scrollableContent = { scaffoldModifier ->
            NewsContent(
                modifier = scaffoldModifier,
                // todo
                state = NewsContentState.Progress,
//                state = searchVm.state.contentState,
                onRetryClicked = {}
//                onRetryClicked = searchVm::retrySearch
            )
        })
}

@Preview
@Composable
fun SearchPreview() {
    Search()
}