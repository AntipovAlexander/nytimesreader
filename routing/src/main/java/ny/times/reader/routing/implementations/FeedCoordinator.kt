package ny.times.reader.routing.implementations

import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ny.times.reader.navigation.FeedNavigator
import ny.times.reader.news_details.presentation.NewsDetailsFragment
import ny.times.reader.news_details.presentation.argument.NewsDetailsUiModel
import javax.inject.Inject

class FeedCoordinator @Inject constructor(private val router: Router) : FeedNavigator {

    override fun goToNewsDetails(
        headline: String,
        abstract: String,
        leadParagraph: String,
        image: String,
        sourceName: String,
        sourceUrl: String,
        tags: List<String>
    ) {
        val newsDetails = NewsDetailsUiModel(
            headline = headline,
            abstract = abstract,
            leadParagraph = leadParagraph,
            image = image,
            sourceName = sourceName,
            sourceUrl = sourceUrl,
            tags = tags
        )
        router.navigateTo(
            FragmentScreen(
                key = NewsDetailsFragment::class.java.simpleName,
                fragmentCreator = { NewsDetailsFragment.newInstance(newsDetails) }
            )
        )
    }

}