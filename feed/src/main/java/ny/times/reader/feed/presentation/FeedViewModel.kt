package ny.times.reader.feed.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ny.times.reader.base.data.entity.doOnError
import ny.times.reader.base.data.entity.doOnSuccess
import ny.times.reader.base.data.entity.map
import ny.times.reader.base.presentation.ui.ChipContent
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.feed.domain.use_case.GetNewsListUseCase
import ny.times.reader.feed.domain.use_case.GetTopicsUseCase
import ny.times.reader.feed.presentation.data.toUiModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getTopicsUseCase: GetTopicsUseCase,
    private val getNewsListUseCase: GetNewsListUseCase,
) : BaseViewModel<FeedViewState>(FeedViewState.Initial) {

    companion object {
        const val DEFAULT_SELECTED_CATEGORY = 0
    }

    init {
        loadTopics()
        loadNews()
    }

    private fun loadTopics() = viewModelScope.launch {
        getTopicsUseCase(Unit)
            .map { it.mapIndexed { i, topic -> topic.toUiModel(i == DEFAULT_SELECTED_CATEGORY) } }
            .doOnSuccess { sendAction(FeedViewActions.UpdateChips(it)) }
            .doOnError(Timber::d)
    }

    private fun loadNews() = viewModelScope.launch {
        getNewsListUseCase(Unit)
            .map { it.map { topic -> topic.toUiModel() } }
            .doOnSuccess { sendAction(FeedViewActions.UpdateNews(it)) }
            .doOnError(Timber::d)
    }

    override fun onReduceState(viewAction: BaseViewAction): FeedViewState = when (viewAction) {
        is FeedViewActions.UpdateChips -> state.copy(chips = viewAction.chips)
        is FeedViewActions.UpdateNews -> state.copy(news = viewAction.news)
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