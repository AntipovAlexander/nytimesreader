package ny.times.reader.feed

import androidx.compose.runtime.mutableStateOf
import ny.times.reader.base.presentation.ui.ChipContent
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel

class FeedViewModel : BaseViewModel<FeedViewState>(FeedViewState.Initial) {

    val chipsState = mutableStateOf(state.chips)

    // todo: will be moved somewhere
    private val initialChips = listOf(
        ChipContent(1, "Culture", true),
        ChipContent(2, "Science", false),
        ChipContent(3, "Technologies", false),
        ChipContent(4, "Music", false),
        ChipContent(5, "Arts", false),
        ChipContent(6, "Investment", false),
        ChipContent(7, "Business", false)
    )

    init {
        sendAction(FeedViewActions.UpdateChips(initialChips))
    }

    override fun onReduceState(viewAction: BaseViewAction): FeedViewState = when (viewAction) {
        is FeedViewActions.UpdateChips -> state.copy(chips = viewAction.chips)
        else -> state
    }

    fun chipSelected(selectedChip: ChipContent) {
        val chips = state.chips
        val oldSelected = chips.indexOfFirst { it.isSelected }
        if (oldSelected == -1) return
        val newSelected = chips.indexOf(selectedChip)
        if (newSelected == -1) return
        val updatedChips = buildList {
            addAll(chips)
            this[oldSelected] = chips[oldSelected].copy(isSelected = false)
            this[newSelected] = chips[newSelected].copy(isSelected = true)
        }
        sendAction(FeedViewActions.UpdateChips(updatedChips))
    }

}