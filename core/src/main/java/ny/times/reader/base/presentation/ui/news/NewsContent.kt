package ny.times.reader.base.presentation.ui.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.entity.news.NewsUiEntity
import ny.times.reader.base.presentation.ui.placeholders.EmptyPlaceholder
import ny.times.reader.base.presentation.ui.placeholders.ErrorPlaceholder
import ny.times.reader.base.presentation.ui.widget.CircularProgress
import ny.times.reader.base.presentation.ui.widget.ListCircularProgress
import ny.times.reader.base.theme.TimesReaderTheme

@Composable
fun NewsContent(
    modifier: Modifier = Modifier,
    state: NewsContentState,
    paginationInProgress: Boolean,
    onRetryClicked: () -> Unit = {},
    lastVisibleItemChanged: (Int) -> Unit = {}
) {
    Box(modifier = modifier) {
        when (state) {
            is NewsContentState.Progress -> CircularProgress()
            is NewsContentState.HasContent -> NewsList(
                state.news,
                paginationInProgress,
                lastVisibleItemChanged
            )
            is NewsContentState.EmptyState -> EmptyPlaceholder(text = state.text)
            is NewsContentState.ErrorState -> ErrorPlaceholder(
                errorText = state.text,
                onRetryClick = { onRetryClicked() })
        }
    }
}

private const val PAGINATION_ITEM_KEY = "pagination"

@Composable
fun NewsList(
    news: List<NewsUiEntity>,
    paginationInProgress: Boolean,
    lastVisibleItemChanged: (Int) -> Unit
) {
    val listState = rememberLazyListState()
    LazyColumn(state = listState) {
        itemsIndexed(items = news, key = { _, item -> item.id }) { index, item ->
            NewsListItem(item)
            val isLastElement = index + 1 == news.size
            if (!isLastElement)
                Divider(
                    color = TimesReaderTheme.colors.lightGrey,
                    modifier = Modifier.padding(16.dp)
                )
            else
                Spacer(modifier = Modifier.height(16.dp))
        }
        if (paginationInProgress) item(key = PAGINATION_ITEM_KEY) { ListCircularProgress() }
    }
    LaunchedEffect(listState) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull() }
            .filter { it?.key != PAGINATION_ITEM_KEY }
            .map { it?.index }
            .filterNotNull()
            .distinctUntilChanged()
            .collect { lastVisibleItemChanged(it) }
    }
}