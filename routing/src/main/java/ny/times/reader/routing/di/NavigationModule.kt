package ny.times.reader.routing.di

import android.content.Context
import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.ActivityScoped
import ny.times.reader.routing.R
import ny.times.reader.routing.navigator.ApplicationNavigator

@Module
@InstallIn(ActivityComponent::class)
class NavigationModule {

    @Provides
    @ActivityScoped
    fun provideAppNavigator(@ActivityContext context: Context) =
        ApplicationNavigator(context as FragmentActivity, R.id.container)

}
