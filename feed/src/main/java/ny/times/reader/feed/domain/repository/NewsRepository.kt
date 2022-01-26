package ny.times.reader.feed.domain.repository

import ny.times.reader.feed.domain.entity.News

interface NewsRepository {
    suspend fun getNewsForCategory(category: String): List<News>
}