package ny.times.reader.feed.presentation

import ny.times.reader.base.presentation.ui.ChipContent
import ny.times.reader.base.presentation.view_model.BaseViewState

data class FeedViewState(val chips: List<ChipContent>) : BaseViewState {
    companion object {
        val Initial = FeedViewState(
            chips = emptyList()
        )
    }
}
