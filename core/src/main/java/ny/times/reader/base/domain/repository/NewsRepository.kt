package ny.times.reader.base.domain.repository

import ny.times.reader.base.domain.entity.News

interface NewsRepository {
    suspend fun getNewsForCategory(category: String): List<News>

    suspend fun searchNewsByQuery(query: String): List<News>
}