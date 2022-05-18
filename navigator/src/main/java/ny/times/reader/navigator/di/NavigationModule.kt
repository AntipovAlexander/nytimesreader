package ny.times.reader.navigator.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ny.times.reader.navigator.NavigationCommander
import ny.times.reader.navigator.NavigationManager
import ny.times.reader.navigator.NavigationObserver
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    @Singleton
    fun provideNavigationCommander(navigationManager: NavigationManager): NavigationCommander

    @Binds
    @Singleton
    fun provideNavigationObserver(navigationManager: NavigationManager): NavigationObserver

}