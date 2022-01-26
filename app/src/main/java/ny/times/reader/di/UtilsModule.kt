package ny.times.reader.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ny.times.reader.base.utils.provider.AndroidResourceProvider
import ny.times.reader.base.utils.provider.ResourceProvider
import ny.times.reader.base.utils.time_formatter.SocialTimeFormatter
import ny.times.reader.base.utils.time_formatter.SocialTimeFormatterImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UtilsModule {

    @Binds
    @Singleton
    fun provideTimeFormatter(timeFormatterImpl: SocialTimeFormatterImpl): SocialTimeFormatter

    @Binds
    @Singleton
    fun provideResourceProvider(androidResourceProvider: AndroidResourceProvider): ResourceProvider

}