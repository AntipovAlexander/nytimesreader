package ny.times.reader.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ny.times.reader.home.presentation.ui.Home
import ny.times.reader.navigator.app.AppRoutes
import ny.times.reader.news_details.presentation.entity.NewsDetailsUiEntity
import ny.times.reader.news_details.presentation.ui.NewsDetailsUi

@Composable
fun AppActivityUi(appViewModel: AppViewModel) {

    val navController = rememberNavController()

    LaunchedEffect(appViewModel) { navController.attachRouter(appViewModel.router) }

    NavHost(navController = navController, startDestination = AppRoutes.HomeTabs.route) {
        composable(AppRoutes.HomeTabs.route) {
            Home(hiltViewModel())
        }
        composable(
            route = AppRoutes.NewsDetails.route,
            arguments = AppRoutes.NewsDetails.arguments
        ) {
            val newsDetails = with(requireNotNull(it.arguments)) {
                NewsDetailsUiEntity(
                    headline = getString(AppRoutes.NewsDetails.KEY_HEADLINE, ""),
                    abstract = getString(AppRoutes.NewsDetails.KEY_ABSTRACT, ""),
                    leadParagraph = getString(AppRoutes.NewsDetails.KEY_LEAD_PARAGRAPH, ""),
                    image = getString(AppRoutes.NewsDetails.KEY_IMAGE, ""),
                    sourceName = getString(AppRoutes.NewsDetails.KEY_SOURCE_NAME, ""),
                    sourceUrl = getString(AppRoutes.NewsDetails.KEY_SOURCE_URL, ""),
                    tags = emptyList() // todo
                )
            }

            NewsDetailsUi(
                details = newsDetails,
                onBackPressed = appViewModel::onBackPressed,
                continueReadingClicked = {
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