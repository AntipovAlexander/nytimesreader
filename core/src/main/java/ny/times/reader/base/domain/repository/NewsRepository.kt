package ny.times.reader.base.domain.repository

import kotlinx.coroutines.flow.Flow
import ny.times.reader.base.domain.entity.News

interface NewsRepository {
    val newsFlow: Flow<List<News>>
    suspend fun getNewsForCategory(category: String, page: Int)
    suspend fun searchNewsByQuery(query: String, firstPage: Boolean): List<News>
}