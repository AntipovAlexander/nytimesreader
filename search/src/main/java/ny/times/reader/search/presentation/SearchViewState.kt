package ny.times.reader.search.presentation

import ny.times.reader.base.presentation.entity.news.NewsContentState
import ny.times.reader.base.presentation.view_model.BaseViewState

data class SearchViewState(
    val searchQuery: String,
    val contentState: NewsContentState
) : BaseViewState
