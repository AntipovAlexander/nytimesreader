package ny.times.reader.feed.presentation

import ny.times.reader.base.presentation.ui.ChipContent
import ny.times.reader.base.presentation.view_model.BaseViewState
import ny.times.reader.feed.presentation.data.NewsUiEntity

data class FeedViewState(
    val chips: List<ChipContent>,
    val contentState: ContentState
) : BaseViewState {
    companion object {
        val Initial = FeedViewState(
            chips = emptyList(),
            contentState = ContentState.Progress,
        )
    }
}

sealed class ContentState {
    class ErrorState(val text: String) : ContentState()
    class HasContent(val news: List<NewsUiEntity>) : ContentState()
    object Progress : ContentState()
}
