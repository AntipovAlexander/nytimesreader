package ny.times.reader.routing.di

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ny.times.reader.routing.navigator.ApplicationNavigatorHolder
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GlobalNavigationModule {

    private val cicerone = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(): Router = cicerone.router

    @Provides
    @Singleton
    fun provideNavigationHolder(): ApplicationNavigatorHolder =
        ApplicationNavigatorHolder(cicerone)

}
