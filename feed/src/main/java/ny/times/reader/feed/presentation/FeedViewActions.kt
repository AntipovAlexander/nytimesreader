package ny.times.reader.feed.presentation

import ny.times.reader.base.presentation.ui.ChipContent
import ny.times.reader.base.presentation.view_model.BaseViewAction

sealed class FeedViewActions : BaseViewAction {
    data class UpdateChips(val chips: List<ChipContent>) : FeedViewActions()
}
