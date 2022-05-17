package ny.times.reader.search.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.entity.news.NewsUiEntity
import ny.times.reader.search.presentation.SearchViewState

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
private val searchState = SearchViewState(
    searchQuery = "Test query",
    contentState = contentState
)

@Preview
@Composable
private fun SearchPreview() {
    Search(
        searchState = searchState,
        itemClicked = {},
        searchQueryChanged = {},
        retryClicked = {}
    )
}