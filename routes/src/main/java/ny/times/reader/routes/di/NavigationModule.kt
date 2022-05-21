package ny.times.reader.routes.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ny.times.reader.navigator.app.AppNavigation
import ny.times.reader.navigator.home_tabs.HomeTabsNavigation
import ny.times.reader.routes.app.AppNavigationImpl
import ny.times.reader.routes.home.HomeTabsNavigationImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    @Singleton
    fun provideHomeNavigation(homeTabsTabsNavigationImpl: HomeTabsNavigationImpl): HomeTabsNavigation

    @Binds
    @Singleton
    fun provideAppNavigation(appNavigationImpl: AppNavigationImpl): AppNavigation

}
