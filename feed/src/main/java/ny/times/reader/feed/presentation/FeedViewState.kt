package ny.times.reader.feed.presentation

import ny.times.reader.base.presentation.ui.ChipContent
import ny.times.reader.base.presentation.view_model.BaseViewState
import ny.times.reader.feed.presentation.data.NewsUiEntity

data class FeedViewState(
    val chips: List<ChipContent>,
    val news: List<NewsUiEntity>
) : BaseViewState {
    companion object {
        val Initial = FeedViewState(
            chips = emptyList(),
            news = emptyList(),
        )
    }
}
