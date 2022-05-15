package ny.times.reader.search.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.entity.news.NewsUiEntity

private val domainNews = (0..10).map {
    News(
        id = it.toString(),
        imageUrl = "",
        thumbUrl = "",
        title = "Title $it",
        snippet = "Snippet $it",
        leadParagraph = "Lead paragraph $it",
        source = "Source $it",
        authorName = "Author $it",
        postedAt = "posted at $it",
        url = "url",
        keywords = emptyList()
    )
}
private val uiNews = (0..10).map {
    NewsUiEntity(
        id = it.toString(),
        thumb = "",
        title = "Title $it",
        authorName = "Author $it",
        postedAgo = "posted ago $it",
    )
}

private val contentState = NewsContentState.HasContent(uiNews, domainNews)

@Preview
@Composable
fun SearchUiPreview() {
    SearchUi(
        searchText = "query",
        contentState = contentState,
        onSearchChanged = {},
        onRetryClick = {}
    )
}