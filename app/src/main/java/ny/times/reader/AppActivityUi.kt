package ny.times.reader

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ny.times.reader.home.ui.Home
import ny.times.reader.news_details.presentation.argument.NewsDetailsData
import ny.times.reader.news_details.presentation.argument.NewsDetailsNavType
import ny.times.reader.news_details.presentation.ui.NewsDetailsUi

private const val HOME = "home"
private const val NEWS_DETAILS_ARGUMENT = "argument"
private const val NEWS_DETAILS = "news_details"

@Composable
fun AppActivityUi() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) {
            Home {
                val testParam = NewsDetailsData(
                    it.title,
                    it.snippet,
                    it.leadParagraph,
                    it.imageUrl,
                    it.source,
                    it.url,
                    it.keywords
                )
                val json = Json.encodeToString(testParam)
                navController.navigate("$NEWS_DETAILS/${Uri.encode(json)}")
            }
        }
        composable(
            route = "$NEWS_DETAILS/{$NEWS_DETAILS_ARGUMENT}",
            arguments = listOf(navArgument(NEWS_DETAILS_ARGUMENT) { type = NewsDetailsNavType() })
        ) {
            val details = it.arguments
                ?.getParcelable<NewsDetailsData>(NEWS_DETAILS_ARGUMENT)
                ?: return@composable
            NewsDetailsUi(
                details = details,
                continueReadingClicked = {
                    // todo:
                },
                backPressedClick = {
                    // todo:
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppActivity()
}