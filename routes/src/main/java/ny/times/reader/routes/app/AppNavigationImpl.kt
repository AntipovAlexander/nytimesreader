package ny.times.reader.routes.app

import ny.times.reader.navigator.app.AppNavigation
import ny.times.reader.navigator.app.AppRoutes
import ny.times.reader.routes.base.NavigationManager
import javax.inject.Inject

class AppNavigationImpl @Inject constructor(
    private val navigationManager: NavigationManager
) : AppNavigation {
    override fun navigateToNewsDetails(
        headline: String,
        abstract: String,
        leadParagraph: String,
        image: String,
        sourceName: String,
        sourceUrl: String,
        tags: Array<String>
    ) {
        val destination = AppRoutes.NewsDetails(
            headline = headline,
            abstract = abstract,
            leadParagraph = leadParagraph,
            image = image,
            sourceName = sourceName,
            sourceUrl = sourceUrl,
            tags = tags
        )
        navigationManager.navigateTo(destination)
    }

    override fun navigateBack() {
        // todo
//        navigationManager.navigateTo(AppRoutes.Back)
    }
}