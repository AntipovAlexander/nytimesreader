package ny.times.reader.feed.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ny.times.reader.feed.data.repository.NewsRepositoryImpl
import ny.times.reader.feed.domain.repository.NewsRepository

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    @ViewModelScoped
    fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

}