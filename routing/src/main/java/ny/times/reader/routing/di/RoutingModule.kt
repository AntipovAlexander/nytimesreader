package ny.times.reader.routing.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ny.times.reader.navigation.ExitNavigator
import ny.times.reader.navigation.FeedNavigator
import ny.times.reader.navigation.HomeNavigator
import ny.times.reader.navigation.HostNavigator
import ny.times.reader.routing.implementations.ExitCoordinator
import ny.times.reader.routing.implementations.FeedCoordinator
import ny.times.reader.routing.implementations.HomeCoordinator
import ny.times.reader.routing.implementations.HostCoordinator
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RoutingModule {

    @Binds
    @Singleton
    fun provideFeedNavigator(feedCoordinator: FeedCoordinator): FeedNavigator

    @Binds
    @Singleton
    fun provideHostCoordinator(hostCoordinator: HostCoordinator): HostNavigator

    @Binds
    @Singleton
    fun provideExitCoordinator(exitCoordinator: ExitCoordinator): ExitNavigator

    @Binds
    @Singleton
    fun provideHomeCoordinator(homeCoordinator: HomeCoordinator): HomeNavigator

}
