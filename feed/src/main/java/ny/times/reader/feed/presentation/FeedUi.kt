package ny.times.reader.feed.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ny.times.reader.base.presentation.ui.ChipGroup
import ny.times.reader.base.presentation.ui.Toolbar
import ny.times.reader.feed.R

@Composable
fun Feed(feedVm: FeedViewModel = hiltViewModel()) {
    Column {
        Toolbar(text = stringResource(R.string.feed))
        ChipGroup(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            chips = feedVm.state.chips,
            onSelectedChanged = feedVm::chipSelected
        )
    }
}

@Preview
@Composable
fun FeedPreview() {
    Feed()
}