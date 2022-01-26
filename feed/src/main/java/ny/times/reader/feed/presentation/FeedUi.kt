package ny.times.reader.feed.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ny.times.reader.base.presentation.ui.ChipGroup
import ny.times.reader.base.presentation.ui.Toolbar
import ny.times.reader.base.theme.TimesReaderTheme
import ny.times.reader.feed.R
import ny.times.reader.feed.presentation.list.NewsListItem

@Composable
fun Feed(feedVm: FeedViewModel = hiltViewModel()) {
    Column {
        Toolbar(text = stringResource(R.string.feed))
        ChipGroup(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            chips = feedVm.state.chips,
            onSelectedChanged = feedVm::chipSelected
        )
        LazyColumn {
            itemsIndexed(
                items = feedVm.state.news,
                key = { _, item -> item.id }
            ) { index, news ->
                NewsListItem(news)
                val isLastElement = index + 1 == feedVm.state.news.size
                if (!isLastElement)
                    Divider(
                        color = TimesReaderTheme.colors.lightGrey,
                        modifier = Modifier.padding(16.dp)
                    )
                else
                    Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
fun FeedPreview() {
    Feed()
}