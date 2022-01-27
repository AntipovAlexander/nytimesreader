package ny.times.reader.search.presentation

import ny.times.reader.base.presentation.entity.news.NewsUiEntity
import ny.times.reader.base.presentation.view_model.BaseViewAction

sealed class SearchViewActions : BaseViewAction {
    data class UpdateSearchResults(val results: List<NewsUiEntity>) : SearchViewActions()
    data class SetError(val error: String) : SearchViewActions()
    data class SetSearchQuery(val query: String) : SearchViewActions()
    data class EmptyState(val text: String) : SearchViewActions()
    object StartLoading : SearchViewActions()
}
