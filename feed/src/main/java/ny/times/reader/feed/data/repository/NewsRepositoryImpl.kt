package ny.times.reader.feed.data.repository

import ny.times.reader.feed.data.network.NewsApi
import ny.times.reader.feed.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(private val newsApi: NewsApi) : NewsRepository {

    override suspend fun getNewsForCategory(category: String) =
        newsApi.searchNewsList("news_desk:($category)").convert()
}