package ny.times.reader.base.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import ny.times.reader.base.data.network.NewsApi
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsApi: NewsApi) : NewsRepository {

    companion object {
        private const val DEFAULT_SORTING_KEY = "newest"
    }

    private val _news = MutableStateFlow<List<News>?>(null)
    override val newsFlow: Flow<List<News>> = _news.filterNotNull()

    override suspend fun getNewsForCategory(category: String, page: Int) {
        val query = "news_desk:($category)"
        val response = newsApi.newsListByCategory(query, DEFAULT_SORTING_KEY, page)
        val previousNews = if (page == 0) emptyList() else (_news.value ?: emptyList())
        _news.value = previousNews + response.response.docs.map { it.convert() }
    }

    override suspend fun searchNewsByQuery(query: String): List<News> =
        newsApi.newsListByQuery(
            query = query,
            sort = DEFAULT_SORTING_KEY
        ).convert()
}