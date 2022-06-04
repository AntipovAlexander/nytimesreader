package ny.times.reader.feed.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ny.times.reader.base.presentation.ui.news.NewsContent
import ny.times.reader.base.presentation.ui.widget.ChipContent
import ny.times.reader.base.presentation.ui.widget.ChipGroup
import ny.times.reader.base.presentation.ui.widget.EnterAlwaysScaffold
import ny.times.reader.base.presentation.ui.widget.Toolbar
import ny.times.reader.base.theme.TimesReaderTheme
import ny.times.reader.feed.R
import ny.times.reader.feed.presentation.ui.PreviewData

@Composable
fun FeedUi(feedVm: FeedViewModel) {
    Feed(
        feedState = feedVm.state,
        onChipSelected = feedVm::chipSelected,
        onRetryClick = feedVm::retryClicked,
        onLastVisibleItemChanged = feedVm::lastVisibleItemChanged,
        onItemClick = feedVm::onNewsDetailsClicked
    )
}

@Composable
internal fun Feed(
    feedState: FeedViewState,
    onChipSelected: (chip: ChipContent) -> Unit,
    onItemClick: (id: String) -> Unit,
    onRetryClick: () -> Unit,
    onLastVisibleItemChanged: (position: Int) -> Unit
) {
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
                chips = feedState.chips,
                onSelectedChanged = onChipSelected
            )
        },
        scrollableContent = { scaffoldModifier ->
            NewsContent(
                itemClick = onItemClick,
                modifier = scaffoldModifier,
                state = feedState.contentState,
                onRetryClicked = onRetryClick,
                paginationInProgress = feedState.paginationInProgress,
                lastVisibleItemChanged = onLastVisibleItemChanged
            )
        }
    )
}

@Preview
@Composable
fun FeedPreview() {
    Feed(
        feedState = PreviewData.get(),
        onChipSelected = {},
        onItemClick = {},
        onRetryClick = {},
        onLastVisibleItemChanged = {}
    )
}