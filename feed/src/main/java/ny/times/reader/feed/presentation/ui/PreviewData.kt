package ny.times.reader.feed.presentation.ui

import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.entity.news.NewsUiEntity
import ny.times.reader.base.presentation.ui.widget.ChipContent
import ny.times.reader.feed.presentation.FeedViewState

internal object PreviewData {

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
    private val chips = (0..10).map { ChipContent(it.toLong(), "Chip #$it", it == 1) }
    fun get() = FeedViewState(
        chips = chips,
        contentState = contentState,
        paginationInProgress = false,
        nextPage = 0
    )
}