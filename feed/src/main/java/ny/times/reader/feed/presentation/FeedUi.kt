package ny.times.reader.feed.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.ui.news.NewsContent
import ny.times.reader.base.presentation.ui.widget.ChipContent
import ny.times.reader.base.presentation.ui.widget.ChipGroup
import ny.times.reader.base.presentation.ui.widget.EnterAlwaysScaffold
import ny.times.reader.base.presentation.ui.widget.Toolbar
import ny.times.reader.base.theme.TimesReaderTheme
import ny.times.reader.feed.R

@Composable
fun Feed(newsClicked: (News) -> Unit) {
    val chipPadding = 8.dp
    EnterAlwaysScaffold(
        toolbar = { scaffoldModifier ->
            Toolbar(
                modifier = scaffoldModifier,
                text = stringResource(R.string.feed)
            )
        },
        enterAlwaysBar = { scaffoldModifier ->
            ChipGroup(
                modifier = scaffoldModifier.then(
                    Modifier
                        .background(TimesReaderTheme.colors.white)
                        .padding(vertical = chipPadding)
                ),
                // todo
                chips = emptyList<ChipContent>(),
//                chips = feedVm.state.chips,
                onSelectedChanged = {}
//                onSelectedChanged = feedVm::chipSelected
            )
        },
        scrollableContent = { scaffoldModifier ->
            NewsContent(
                itemClick = { id ->
                    // todo
//                    val newsItem = feedVm.getById(id) ?: return@NewsContent
//                    newsClicked(newsItem)
                },
                modifier = scaffoldModifier,
                // todo
                state = NewsContentState.Progress,
//                state = feedVm.state.contentState,
                onRetryClicked = {},
//                onRetryClicked = feedVm::retryClicked,
                paginationInProgress = false,
//                paginationInProgress = feedVm.state.paginationInProgress,
                lastVisibleItemChanged = {}
//                lastVisibleItemChanged = feedVm::lastVisibleItemChanged
            )
        }
    )
}

@Preview
@Composable
fun FeedPreview() {
    Feed(newsClicked = {})
}