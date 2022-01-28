package ny.times.reader.feed.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ny.times.reader.base.presentation.ui.news.NewsContent
import ny.times.reader.base.presentation.ui.widget.ChipGroup
import ny.times.reader.base.presentation.ui.widget.Toolbar
import ny.times.reader.feed.R
import kotlin.math.roundToInt

@Composable
fun Feed(feedVm: FeedViewModel = hiltViewModel()) {
    val chipOffset = remember { mutableStateOf(0f) }
    val chipHeight = remember { mutableStateOf(0) }
    val toolbarHeight = remember { mutableStateOf(0) }
    val chipPadding = 8.dp
    val chipPaddingPx = with(LocalDensity.current) { chipPadding.roundToPx().toFloat() }
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = chipOffset.value + delta
                val paddedHeight = chipHeight.value + chipPaddingPx * 2
                chipOffset.value = newOffset.coerceIn(-paddedHeight, 0f)
                return if (chipOffset.value < 0 && chipOffset.value > -paddedHeight) available else Offset.Zero
            }
        }
    }
    Box {
        Column(modifier = Modifier
            .nestedScroll(nestedScrollConnection)
            .offset { IntOffset(0, chipOffset.value.roundToInt() + toolbarHeight.value) })
        {
            ChipGroup(
                modifier = Modifier
                    .padding(vertical = chipPadding)
                    .onGloballyPositioned { chipHeight.value = it.size.height },
                chips = feedVm.state.chips,
                onSelectedChanged = feedVm::chipSelected
            )
            NewsContent(state = feedVm.state.contentState, onRetryClicked = feedVm::retryClicked)
        }
        Toolbar(
            modifier = Modifier.onGloballyPositioned { toolbarHeight.value = it.size.height },
            text = stringResource(R.string.feed)
        )
    }
}

@Preview
@Composable
fun FeedPreview() {
    Feed()
}