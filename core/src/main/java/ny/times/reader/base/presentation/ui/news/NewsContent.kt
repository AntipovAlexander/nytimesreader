package ny.times.reader.base.presentation.ui.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.entity.news.NewsUiEntity
import ny.times.reader.base.presentation.ui.placeholders.EmptyPlaceholder
import ny.times.reader.base.presentation.ui.placeholders.ErrorPlaceholder
import ny.times.reader.base.presentation.ui.widget.CircularProgress
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun NewsContent(
    modifier: Modifier = Modifier,
    state: NewsContentState,
    onRetryClicked: () -> Unit = {}
) {
    Box(modifier = modifier) {
        when (state) {
            is NewsContentState.Progress -> CircularProgress()
            is NewsContentState.HasContent -> NewsList(state.news)
            is NewsContentState.EmptyState -> EmptyPlaceholder(text = state.text)
            is NewsContentState.ErrorState -> ErrorPlaceholder(
                errorText = state.text,
                onRetryClick = { onRetryClicked() })
        }
    }
}

@Composable
fun NewsList(news: List<NewsUiEntity>) {
    LazyColumn {
        itemsIndexed(items = news, key = { _, item -> item.title }) { index, newsItem ->
            NewsListItem(newsItem)
            val isLastElement = index + 1 == news.size
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