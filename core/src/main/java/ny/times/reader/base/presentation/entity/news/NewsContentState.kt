package ny.times.reader.base.presentation.entity.news

sealed class NewsContentState {
    class ErrorState(val text: String) : NewsContentState()
    class EmptyState(val text: String) : NewsContentState()
    class HasContent(val news: List<NewsUiEntity>) : NewsContentState()
    object Progress : NewsContentState()
}