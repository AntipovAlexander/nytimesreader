package ny.times.reader.base.data.repository

import ny.times.reader.base.data.network.NewsApi
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsApi: NewsApi) : NewsRepository {

    companion object {
        private const val DEFAULT_SORTING_KEY = "newest"
    }

    override suspend fun getNewsForCategory(category: String) =
        newsApi.newsListByCategory(
            query = "news_desk:($category)",
            sort = DEFAULT_SORTING_KEY
        ).convert()

    override suspend fun searchNewsByQuery(query: String): List<News> =
        newsApi.newsListByCategory(
            query = query,
            sort = DEFAULT_SORTING_KEY
        ).convert()
}