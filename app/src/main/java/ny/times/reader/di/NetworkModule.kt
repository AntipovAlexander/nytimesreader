package ny.times.reader.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import ny.times.reader.base.BuildConfig
import ny.times.reader.base.network.interceptors.CommonRequestInterceptor
import okhttp3.Dispatcher
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
    }

    @Provides
    @Singleton
    fun provideChuckerInterceptor(@ApplicationContext applicationContext: Context): ChuckerInterceptor =
        ChuckerInterceptor.Builder(applicationContext).run {
            collector(ChuckerCollector(applicationContext))
            maxContentLength(250000L)
            redactHeaders(emptySet())
            alwaysReadResponseBody(false)
            build()
        }

    @Provides
    @Singleton
    fun provideOkHttpDispatcher() = Dispatcher()

    @Provides
    @Singleton
    fun provideOkHttp(
        dispatcher: Dispatcher,
        loggingInterceptor: HttpLoggingInterceptor,
        chuckerInterceptor: ChuckerInterceptor,
        commonRequestInterceptor: CommonRequestInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .dispatcher(dispatcher)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(chuckerInterceptor)
            .addInterceptor(commonRequestInterceptor)
            .build()
    }

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory =
        Json {
            ignoreUnknownKeys = true
            isLenient = true
        }.asConverterFactory("application/json".toMediaType())


    @Provides
    @Singleton
    fun provideRetrofit(
        httpClient: OkHttpClient,
        converterFactory: Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_API_URL)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(httpClient)
            .build()
    }
}
