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
import ny.times.reader.base.utils.time_formatter.SocialTimeFormatter
import ny.times.reader.feed.domain.use_case.GetNewsListUseCase
import ny.times.reader.feed.domain.use_case.GetTopicsUseCase
import ny.times.reader.feed.presentation.data.toUiModel
import timber.log.Timber
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getTopicsUseCase: GetTopicsUseCase,
    private val getNewsListUseCase: GetNewsListUseCase,
    private val socialTimeFormatter: SocialTimeFormatter,
    private val dateFormat: SimpleDateFormat
) : BaseViewModel<FeedViewState>(FeedViewState.Initial) {

    companion object {
        const val DEFAULT_SELECTED_CATEGORY = 0
    }

    init {
        loadTopics()
    }

    override fun onReduceState(viewAction: BaseViewAction): FeedViewState = when (viewAction) {
        is FeedViewActions.UpdateChips -> state.copy(chips = viewAction.chips)
        is FeedViewActions.StartLoading -> state.copy(contentState = ContentState.Progress)
        is FeedViewActions.SetError -> state.copy(contentState = ContentState.ErrorState(viewAction.error))
        is FeedViewActions.UpdateNews -> state.copy(
            contentState = ContentState.HasContent(
                viewAction.news
            )
        )
        else -> state
    }

    private fun loadTopics() = viewModelScope.launch {
        getTopicsUseCase(Unit)
            .map { it.mapIndexed { i, topic -> topic.toUiModel(i == DEFAULT_SELECTED_CATEGORY) } }
            .doOnSuccess {
                loadNews(it.first().text)
                sendAction(FeedViewActions.UpdateChips(it))
            }
            .doOnError(Timber::d)
    }

    private fun loadNews(category: String) = viewModelScope.launch {
        sendAction(FeedViewActions.StartLoading)
        getNewsListUseCase(category)
            .map { newsList ->
                newsList.map { news -> news.toUiModel(dateFormat, socialTimeFormatter) }
            }
            .doOnSuccess { sendAction(FeedViewActions.UpdateNews(it)) }
            .doOnError { sendAction(FeedViewActions.SetError("Error happened. Please retry.")) }
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
        loadNews(selectedChip.text)
    }

    fun retryClicked() {
        loadNews(state.chips.first { it.isSelected }.text)
    }
}