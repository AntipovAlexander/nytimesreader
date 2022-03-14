package ny.times.reader.base.presentation.entity.news

import ny.times.reader.base.domain.entity.News

sealed class NewsContentState {
    class ErrorState(val text: String) : NewsContentState()
    class EmptyState(val text: String) : NewsContentState()
    class HasContent(val uiNews: List<NewsUiEntity>, val domainNews: List<News>) :
        NewsContentState()

    object Progress : NewsContentState()

    fun newsUi() = (this as? HasContent)?.uiNews

    fun newsDomain() = (this as? HasContent)?.domainNews
}