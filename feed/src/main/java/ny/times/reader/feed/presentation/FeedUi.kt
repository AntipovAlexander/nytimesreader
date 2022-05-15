package ny.times.reader.feed.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.ui.news.NewsContent
import ny.times.reader.base.presentation.ui.widget.ChipContent
import ny.times.reader.base.presentation.ui.widget.ChipGroup
import ny.times.reader.base.presentation.ui.widget.EnterAlwaysScaffold
import ny.times.reader.base.presentation.ui.widget.Toolbar
import ny.times.reader.base.theme.TimesReaderTheme
import ny.times.reader.feed.R

@Composable
fun Feed(
    chips: List<ChipContent>,
    contentState: NewsContentState,
    paginationInProgress: Boolean,
    newsClicked: (id: String) -> Unit,
    chipClicked: (chip: ChipContent) -> Unit,
    lastVisibleItemChanged: (position: Int) -> Unit,
    retryClicked: () -> Unit
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
                chips = chips,
                onSelectedChanged = { chipClicked(it) }
            )
        },
        scrollableContent = { scaffoldModifier ->
            NewsContent(
                itemClick = { id -> newsClicked(id) },
                modifier = scaffoldModifier,
                state = contentState,
                onRetryClicked = { retryClicked() },
                paginationInProgress = paginationInProgress,
                lastVisibleItemChanged = { position -> lastVisibleItemChanged(position) }
            )
        }
    )
}

@Preview
@Composable
fun FeedPreview() {
//    Feed(newsClicked = {})
}