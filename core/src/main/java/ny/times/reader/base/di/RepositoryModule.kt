package ny.times.reader.base.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import ny.times.reader.base.data.repository.NewsRepositoryImpl
import ny.times.reader.base.domain.repository.NewsRepository

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    @ViewModelScoped
    fun provideNewsRepository(newsRepositoryImpl: NewsRepositoryImpl): NewsRepository

}