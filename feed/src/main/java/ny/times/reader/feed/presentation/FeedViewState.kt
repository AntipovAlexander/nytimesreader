package ny.times.reader.feed.presentation

import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.ui.widget.ChipContent
import ny.times.reader.base.presentation.view_model.BaseViewState

data class FeedViewState(
    val chips: List<ChipContent>,
    val contentState: NewsContentState,
    val paginationInProgress: Boolean,
    val nextPage: Int
) : BaseViewState {
    companion object {
        val Initial = FeedViewState(
            chips = emptyList(),
            contentState = NewsContentState.Progress,
            paginationInProgress = false,
            nextPage = 0
        )
    }
}
