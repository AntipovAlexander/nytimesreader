package ny.times.reader.feed.data.repository

import ny.times.reader.feed.data.network.NewsApi
import ny.times.reader.feed.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsApi: NewsApi) : NewsRepository {

    companion object {
        private const val DEFAULT_SORTING_KEY = "newest"
    }

    override suspend fun getNewsForCategory(category: String) =
        newsApi.searchNewsList(
            query = "news_desk:($category)",
            sort = DEFAULT_SORTING_KEY
        ).convert()
}