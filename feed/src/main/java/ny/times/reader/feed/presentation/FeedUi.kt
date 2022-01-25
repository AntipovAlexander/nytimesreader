package ny.times.reader.feed.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ny.times.reader.base.presentation.ui.ChipGroup
import ny.times.reader.base.presentation.ui.Toolbar
import ny.times.reader.feed.R
import ny.times.reader.feed.presentation.data.NewsUiEntity
import ny.times.reader.feed.presentation.list.NewsListItem

@Composable
fun Feed(feedVm: FeedViewModel = hiltViewModel()) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Toolbar(text = stringResource(R.string.feed))
        ChipGroup(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            chips = feedVm.state.chips,
            onSelectedChanged = feedVm::chipSelected
        )

        val data = NewsUiEntity(
            1L,
            "https://images.unsplash.com/photo-1534353436294-0dbd4bdac845?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1287&q=80",
            "Monarch population soars population soars  4,900 percent since last year in thrilling 2021 western migration",
            "by John Doe",
            "2 days ago"
        )
        NewsListItem(data)
        NewsListItem(data)
        NewsListItem(data)
        NewsListItem(data)
        NewsListItem(data)
        NewsListItem(data)
        NewsListItem(data)
        NewsListItem(data)
    }
}

@Preview
@Composable
fun FeedPreview() {
    Feed()
}