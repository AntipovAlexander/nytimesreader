package ny.times.reader.app

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ny.times.reader.home.presentation.ui.Home
import ny.times.reader.navigator.app.AppRoutes
import ny.times.reader.news_details.presentation.argument.NewsDetailsData
import ny.times.reader.news_details.presentation.argument.NewsDetailsNavType
import ny.times.reader.news_details.presentation.ui.NewsDetailsUi

private const val NEWS_DETAILS_ARGUMENT = "argument"
private const val NEWS_DETAILS = "news_details"

@Composable
fun AppActivityUi(appViewModel: AppViewModel) {
    val navController = rememberNavController()
    LaunchedEffect(appViewModel) {
        appViewModel
            .appRoutes
            .onEach { route -> navigate(navController, route) }
            .collect()
    }
    // todo:!
    NavHost(navController = navController, startDestination = "AppRoutes.HomeTabs.route") {
        composable("AppRoutes.HomeTabs.route") {
            Home(hiltViewModel()) {
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
                onBackPressed = { appViewModel.navigateBack() }
            )
        }
    }
}

fun navigate(navController: NavHostController, route: AppRoutes) {
    when (route) {
//        is AppRoutes.Back -> navController.popBackStack()
//        is AppRoutes.HomeTabs -> {
//            // todo:
//        }
//        is AppRoutes.NewsDetails -> {
//            // todo:
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppActivity()
}