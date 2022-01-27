package ny.times.reader.feed.presentation

import ny.times.reader.base.presentation.entity.news.NewsUiEntity
import ny.times.reader.base.presentation.ui.widget.ChipContent
import ny.times.reader.base.presentation.view_model.BaseViewAction

sealed class FeedViewActions : BaseViewAction {
    data class UpdateChips(val chips: List<ChipContent>) : FeedViewActions()
    data class UpdateNews(val news: List<NewsUiEntity>) : FeedViewActions()
    data class SetError(val error: String) : FeedViewActions()
    data class EmptyState(val text: String) : FeedViewActions()
    object StartLoading : FeedViewActions()
}
