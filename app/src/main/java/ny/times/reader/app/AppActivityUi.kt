package ny.times.reader.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import ny.times.reader.home.presentation.ui.Home
import ny.times.reader.navigator.app.AppRoutes
import ny.times.reader.news_details.presentation.entity.NewsDetailsUiEntity
import ny.times.reader.news_details.presentation.ui.NewsDetailsUi

@Composable
fun AppActivityUi(appViewModel: AppViewModel) {
    val navController = rememberNavController()
    LaunchedEffect(appViewModel) {
        appViewModel
            .appRoutes
            .onEach { route -> navigate(navController, route) }
            .collect()
    }
    NavHost(navController = navController, startDestination = AppRoutes.HomeTabs.route) {
        composable(AppRoutes.HomeTabs.route) {
            Home(
                homeViewModel = hiltViewModel(),
                onNewsClicked = appViewModel::onNewsDetailsClicked
            )
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
                continueReadingClicked = {
                    // todo:
                },
                onBackPressed = { appViewModel.navigateBack() }
            )
        }
    }
}

fun navigate(navController: NavHostController, route: AppRoutes) {
    navController.navigate(route.destination)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppActivity()
}