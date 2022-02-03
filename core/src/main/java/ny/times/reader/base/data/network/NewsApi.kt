package ny.times.reader.base.data.network

import ny.times.reader.base.data.entity.NewsList
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("articlesearch.json")
    suspend fun newsListByCategory(
        @Query("fq") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int
    ): NewsList

    @GET("articlesearch.json")
    suspend fun newsListByQuery(
        @Query("q") query: String,
        @Query("sort") sort: String
    ): NewsList
}
