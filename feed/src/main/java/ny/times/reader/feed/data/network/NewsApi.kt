package ny.times.reader.feed.data.network

import ny.times.reader.feed.data.entity.NewsList
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("articlesearch.json")
    suspend fun searchNewsList(
        @Query("fq") query: String,
        @Query("sort") sort: String
    ): NewsList
}
