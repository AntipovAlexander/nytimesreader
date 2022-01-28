package ny.times.reader.feed.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ny.times.reader.base.presentation.ui.news.NewsContent
import ny.times.reader.base.presentation.ui.widget.ChipGroup
import ny.times.reader.base.presentation.ui.widget.EnterAlwaysScaffold
import ny.times.reader.base.presentation.ui.widget.Toolbar
import ny.times.reader.feed.R

@Composable
fun Feed(feedVm: FeedViewModel = hiltViewModel()) {
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
                modifier = scaffoldModifier.then(Modifier.padding(vertical = chipPadding)),
                chips = feedVm.state.chips,
                onSelectedChanged = feedVm::chipSelected
            )
        },
        scrollableContent = { scaffoldModifier ->
            NewsContent(
                modifier = scaffoldModifier,
                state = feedVm.state.contentState,
                onRetryClicked = feedVm::retryClicked
            )
        }
    )
}

@Preview
@Composable
fun FeedPreview() {
    Feed()
}