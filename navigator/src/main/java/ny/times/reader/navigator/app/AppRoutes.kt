package ny.times.reader.navigator.app

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import ny.times.reader.navigator.base.Destination
import ny.times.reader.navigator.base.RouteParams

sealed class AppRoutes : Destination() {

    class HomeTabs : AppRoutes() {

        companion object : RouteParams() {
            override val arguments = emptyList<NamedNavArgument>()
            override val route = "home"
        }

        override val destination: String = route
    }

    class NewsDetails(
        headline: String,
        abstract: String,
        leadParagraph: String,
        image: String,
        sourceName: String,
        sourceUrl: String,
        tags: Array<String>
    ) : AppRoutes() {

        companion object : RouteParams() {

            const val KEY_HEADLINE = "headline"
            const val KEY_ABSTRACT = "abstract"
            const val KEY_LEAD_PARAGRAPH = "lead_paragraph"
            const val KEY_IMAGE = "image"
            const val KEY_SOURCE_NAME = "source_name"
            const val KEY_SOURCE_URL = "source_url"
            const val KEY_TAGS = "tags"

            override val arguments = listOf(
                navArgument(KEY_HEADLINE) { type = NavType.StringType },
                navArgument(KEY_ABSTRACT) { type = NavType.StringType },
                navArgument(KEY_LEAD_PARAGRAPH) { type = NavType.StringType },
                navArgument(KEY_IMAGE) { type = NavType.StringType },
                navArgument(KEY_SOURCE_NAME) { type = NavType.StringType },
                navArgument(KEY_SOURCE_URL) { type = NavType.StringType },
                navArgument(KEY_TAGS) { type = NavType.StringArrayType }
            )
            override val route = "news_details?" +
                    "&$KEY_HEADLINE={$KEY_HEADLINE}" +
                    "&$KEY_ABSTRACT={$KEY_ABSTRACT}" +
                    "&$KEY_LEAD_PARAGRAPH={$KEY_LEAD_PARAGRAPH}" +
                    "&$KEY_IMAGE={$KEY_IMAGE}" +
                    "&$KEY_SOURCE_NAME={$KEY_SOURCE_NAME}" +
                    "&$KEY_SOURCE_URL={$KEY_SOURCE_URL}" +
                    "&$KEY_TAGS={$KEY_TAGS}"
        }

        override val destination = "news_details?" +
                "&$KEY_HEADLINE=$headline" +
                "&$KEY_ABSTRACT=$abstract" +
                "&$KEY_LEAD_PARAGRAPH=$leadParagraph" +
                "&$KEY_IMAGE=$image" +
                "&$KEY_SOURCE_NAME=$sourceName" +
                "&$KEY_SOURCE_URL=$sourceUrl" +
                "&$KEY_TAGS=$tags"
    }

}