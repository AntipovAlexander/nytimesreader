package ny.times.reader.feed.presentation

import ny.times.reader.base.presentation.ui.ChipContent
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.feed.presentation.data.NewsUiEntity

sealed class FeedViewActions : BaseViewAction {
    data class UpdateChips(val chips: List<ChipContent>) : FeedViewActions()
    data class UpdateNews(val news: List<NewsUiEntity>) : FeedViewActions()
}
