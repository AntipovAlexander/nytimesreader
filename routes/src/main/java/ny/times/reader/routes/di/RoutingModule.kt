package ny.times.reader.routes.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ny.times.reader.navigator.home.HomeRouter
import ny.times.reader.routes.home.HomeRouterImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RoutingModule {

    @Binds
    @Singleton
    fun provideHomeRouter(homeRouter: HomeRouterImpl): HomeRouter

}
