package ny.times.reader.search.presentation

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.base.utils.time_formatter.SocialTimeFormatter
import java.text.SimpleDateFormat
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
//    private val getNewsListUseCase: GetNewsListUseCase,
    private val socialTimeFormatter: SocialTimeFormatter,
    private val dateFormat: SimpleDateFormat
) : BaseViewModel<SearchViewState>(SearchViewState.Initial) {

    init {
//        loadTopics()
    }

    override fun onReduceState(viewAction: BaseViewAction): SearchViewState = when (viewAction) {
        is SearchViewActions.StartLoading -> state.copy(
            contentState = NewsContentState.Progress
        )
        is SearchViewActions.SetError -> state.copy(
            contentState = NewsContentState.ErrorState(viewAction.error)
        )
        is SearchViewActions.UpdateSearchResults -> state.copy(
            contentState = NewsContentState.HasContent(viewAction.results)
        )
        is SearchViewActions.EmptyState -> state.copy(
            contentState = NewsContentState.EmptyState
        )
        else -> state
    }

    private fun loadNews(category: String) = viewModelScope.launch {
//        sendAction(SearchViewActions.StartLoading)
//        getNewsListUseCase(category)
//            .map { newsList ->
//                newsList.map { news -> news.toUiModel(dateFormat, socialTimeFormatter) }
//            }
//            .doOnSuccess {
//                if (it.isEmpty())
//                    sendAction(SearchViewActions.EmptyState)
//                else
//                    sendAction(SearchViewActions.UpdateSearchResults(it))
//
//            }
//            .doOnError { sendAction(SearchViewActions.SetError("Error happened. Please retry.")) }
    }
}