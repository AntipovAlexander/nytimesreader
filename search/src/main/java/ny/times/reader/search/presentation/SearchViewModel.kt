package ny.times.reader.search.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ny.times.reader.base.data.entity.base.doOnError
import ny.times.reader.base.data.entity.base.doOnSuccess
import ny.times.reader.base.data.entity.base.map
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.presentation.entity.mappers.toUiModel
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.entity.news.NewsUiEntity
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.base.utils.provider.ResourceProvider
import ny.times.reader.base.utils.time_formatter.SocialTimeFormatter
import ny.times.reader.search.R
import ny.times.reader.search.domain.SearchNewsListUseCase
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchNewsListUseCase: SearchNewsListUseCase,
    private val socialTimeFormatter: SocialTimeFormatter,
    private val resourceProvider: ResourceProvider,
    private val dateFormat: SimpleDateFormat
) : BaseViewModel<SearchViewState>(
    SearchViewState(
        searchQuery = "",
        contentState = NewsContentState.EmptyState(resourceProvider.getString(R.string.empty_state_no_input))
    )
) {

    private val searchQueryFlow = MutableStateFlow("")

    init {
        observeSearchQuery()
    }

    override fun onReduceState(viewAction: BaseViewAction): SearchViewState = when (viewAction) {
        is SearchViewActions.StartLoading -> state.copy(
            contentState = NewsContentState.Progress
        )
        is SearchViewActions.SetError -> state.copy(
            contentState = NewsContentState.ErrorState(viewAction.error)
        )
        is SearchViewActions.UpdateSearchResults -> state.copy(
            contentState = NewsContentState.HasContent(
                viewAction.uiResults,
                viewAction.domainResults
            )
        )
        is SearchViewActions.EmptyState -> state.copy(
            contentState = NewsContentState.EmptyState(text = viewAction.text)
        )
        is SearchViewActions.SetSearchQuery -> state.copy(
            searchQuery = viewAction.query
        )
        else -> state
    }

    fun searchQueryChanged(query: String) = viewModelScope.launch {
        sendAction(SearchViewActions.SetSearchQuery(query))
        searchQueryFlow.emit(query)
    }

    fun retrySearch() = viewModelScope.launch {
        performSearch(searchQueryFlow.value)
    }

    private fun observeSearchQuery() = viewModelScope.launch {
        searchQueryFlow
            .drop(1)
            .debounce(300L)
            .distinctUntilChanged()
            .onEach(::performSearch)
            .collect()
    }

    private suspend fun performSearch(query: String) {
        if (query.isBlank()) {
            onSearchResultsLoaded(emptyList(), emptyList())
            return
        }
        sendAction(SearchViewActions.StartLoading)
        searchNewsListUseCase(query)
            .map { it.map { news -> news.toUiModel(dateFormat, socialTimeFormatter) } to it }
            .doOnSuccess { onSearchResultsLoaded(it.first, it.second) }
            .doOnError { sendAction(SearchViewActions.SetError(resourceProvider.getString(R.string.default_error_text))) }
    }

    private fun onSearchResultsLoaded(uiResult: List<NewsUiEntity>, domainResult: List<News>) {
        if (uiResult.isEmpty()) {
            val emptyText = if (state.searchQuery.isBlank())
                resourceProvider.getString(R.string.empty_state_no_input)
            else
                resourceProvider.getString(R.string.empty_state_no_result)
            sendAction(SearchViewActions.EmptyState(emptyText))
        } else
            sendAction(SearchViewActions.UpdateSearchResults(uiResult, domainResult))
    }

    fun getById(id: String) = state.contentState.newsDomain()?.firstOrNull { it.id == id }
}