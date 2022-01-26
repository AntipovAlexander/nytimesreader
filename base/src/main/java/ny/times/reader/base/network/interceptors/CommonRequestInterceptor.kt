package ny.times.reader.base.network.interceptors

import ny.times.reader.base.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

private const val API_KEY_QUERY = "api-key"

class CommonRequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url =
            chain
                .request()
                .url
                .newBuilder()
                .addQueryParameter(API_KEY_QUERY, BuildConfig.API_KEY)
                .build()
        val request = chain
            .request()
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(request)
    }
}
