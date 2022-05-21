package ny.times.reader.routes.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ny.times.reader.navigator.app.AppRouter
import ny.times.reader.navigator.home_tabs.HomeTabsRouter
import ny.times.reader.routes.app.AppRouterImpl
import ny.times.reader.routes.home.HomeTabsRouterImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RoutingModule {

    @Binds
    @Singleton
    fun provideHomeRouter(homeTabsRouter: HomeTabsRouterImpl): HomeTabsRouter

    @Binds
    @Singleton
    fun provideAppRouter(appRouter: AppRouterImpl): AppRouter

}
