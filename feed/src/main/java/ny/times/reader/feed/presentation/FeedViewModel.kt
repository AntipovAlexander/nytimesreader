package ny.times.reader.feed.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import ny.times.reader.base.data.entity.base.doOnError
import ny.times.reader.base.data.entity.base.doOnSuccess
import ny.times.reader.base.data.entity.base.map
import ny.times.reader.base.data.pagination.PaginationDelegate
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.presentation.entity.mappers.toUiModel
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.entity.news.NewsUiEntity
import ny.times.reader.base.presentation.ui.widget.ChipContent
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.base.utils.provider.ResourceProvider
import ny.times.reader.base.utils.time_formatter.SocialTimeFormatter
import ny.times.reader.feed.R
import ny.times.reader.feed.domain.use_case.GetTopicsUseCase
import ny.times.reader.feed.domain.use_case.ObserveNewsUseCase
import ny.times.reader.feed.domain.use_case.RequestNewsUseCase
import ny.times.reader.feed.presentation.data.toUiModel
import ny.times.reader.navigator.app.AppNavigation
import timber.log.Timber
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val navigation: AppNavigation,
    private val getTopicsUseCase: GetTopicsUseCase,
    private val requestNewsUseCase: RequestNewsUseCase,
    private val observeNewsUseCase: ObserveNewsUseCase,
    private val socialTimeFormatter: SocialTimeFormatter,
    private val resourceProvider: ResourceProvider,
    private val dateFormat: SimpleDateFormat
) : BaseViewModel<FeedViewState>(FeedViewState.Initial) {

    companion object {
        const val DEFAULT_SELECTED_CATEGORY = 0
    }

    init {
        loadTopics()
        observeNews()
    }

    private val paginationDelegate: PaginationDelegate = PaginationDelegate(
        datasetSize = { state.contentState.newsUi()?.size ?: 0 },
        isPaginationInProgress = { state.paginationInProgress },
        requestNextPage = { requestNextPage() }
    )

    private fun observeNews() = viewModelScope.launch {
        observeNewsUseCase(Unit)
            .map { list -> list.map { it.toUiModel(dateFormat, socialTimeFormatter) } to list }
            .collect { onNewsLoaded(it.first, it.second) }
    }

    override fun onReduceState(viewAction: BaseViewAction): FeedViewState = when (viewAction) {
        is FeedViewActions.UpdateChips -> state.copy(
            chips = viewAction.chips
        )
        is FeedViewActions.StartLoading -> state.copy(
            contentState = NewsContentState.Progress
        )
        is FeedViewActions.UpdatePaginationState -> state.copy(
            paginationInProgress = viewAction.isPaginating
        )
        is FeedViewActions.UpdateNextPage -> state.copy(
            nextPage = viewAction.nextPage
        )
        is FeedViewActions.SetError -> state.copy(
            contentState = NewsContentState.ErrorState(viewAction.error)
        )
        is FeedViewActions.UpdateNews -> state.copy(
            contentState = NewsContentState.HasContent(viewAction.uiNews, viewAction.domainNews)
        )
        is FeedViewActions.EmptyState -> state.copy(
            contentState = NewsContentState.EmptyState(viewAction.text)
        )
        else -> state
    }

    fun onNewsDetailsClicked(id: String) {
        val news = state.contentState.newsDomain()?.firstOrNull { it.id == id } ?: return
        navigation.navigateToNewsDetails(
            headline = news.title,
            abstract = news.snippet,
            leadParagraph = news.leadParagraph,
            image = news.imageUrl.ifEmpty { news.thumbUrl },
            sourceName = news.source,
            sourceUrl = news.url,
            tags = news.keywords.toTypedArray()
        )
    }

    private fun loadTopics() = viewModelScope.launch {
        getTopicsUseCase(Unit)
            .map { it.mapIndexed { i, topic -> topic.toUiModel(i == DEFAULT_SELECTED_CATEGORY) } }
            .doOnSuccess {
                requestNewsFromStart(it.first().text)
                sendAction(FeedViewActions.UpdateChips(it))
            }
            .doOnError(Timber::d)
    }

    private fun requestNewsFromStart(category: String) = viewModelScope.launch {
        sendActions(
            FeedViewActions.UpdateNextPage(0),
            FeedViewActions.StartLoading
        )
        val params = RequestNewsUseCase.Params(category, 0)
        requestNewsUseCase(params)
            .doOnError { sendAction(FeedViewActions.SetError(resourceProvider.getString(R.string.default_error_text))) }
    }

    private fun onNewsLoaded(uiList: List<NewsUiEntity>, domainList: List<News>) {
        sendActions(
            FeedViewActions.UpdatePaginationState(false),
            FeedViewActions.UpdateNextPage(state.nextPage + 1)
        )
        if (uiList.isEmpty())
            sendAction(FeedViewActions.EmptyState(resourceProvider.getString(R.string.news_list_empty_text)))
        else
            sendAction(FeedViewActions.UpdateNews(uiList, domainList))
    }

    fun chipSelected(selectedChip: ChipContent) {
        val chips = state.chips
        val oldSelected = chips.indexOfFirst { it.isSelected }
        val newSelected = chips.indexOf(selectedChip)
        if (oldSelected == -1 || newSelected == -1) return
        val updatedChips = buildList {
            addAll(chips)
            this[oldSelected] = chips[oldSelected].copy(isSelected = false)
            this[newSelected] = chips[newSelected].copy(isSelected = true)
        }
        sendAction(FeedViewActions.UpdateChips(updatedChips))
        requestNewsFromStart(selectedChip.text)
    }

    fun lastVisibleItemChanged(currentPosition: Int) = paginationDelegate.paginate(currentPosition)

    private fun requestNextPage() = viewModelScope.launch {
        sendActions(FeedViewActions.UpdatePaginationState(true))
        val currentCategory = state.chips.first { it.isSelected }.text
        val params = RequestNewsUseCase.Params(currentCategory, state.nextPage)
        requestNewsUseCase(params)
            .doOnError { sendAction(FeedViewActions.UpdatePaginationState(false)) }
    }

    fun retryClicked() = requestNewsFromStart(state.chips.first { it.isSelected }.text)

}