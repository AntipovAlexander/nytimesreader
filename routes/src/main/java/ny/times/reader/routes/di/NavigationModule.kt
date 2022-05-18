package ny.times.reader.routes.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ny.times.reader.navigator.home.HomeNavigation
import ny.times.reader.routes.home.HomeNavigationImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    @Singleton
    fun provideHomeNavigation(homeNavigationImpl: HomeNavigationImpl): HomeNavigation

}
