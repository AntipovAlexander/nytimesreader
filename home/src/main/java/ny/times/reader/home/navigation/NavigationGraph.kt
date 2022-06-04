package ny.times.reader.home.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import ny.times.reader.bookmarks.Bookmarks
import ny.times.reader.feed.presentation.FeedUi
import ny.times.reader.navigator.home_tabs.HomeTabsRoutes
import ny.times.reader.search.presentation.ui.SearchUi

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val animationOffset =
        LocalDensity
            .current
            .run { LocalConfiguration.current.screenWidthDp.dp.roundToPx() }
    val animationTime = 300
    AnimatedNavHost(
        navController = navController,
        startDestination = HomeTabsRoutes.Feed.route,
        modifier = modifier,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { animationOffset },
                animationSpec = tween(animationTime)
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -animationOffset },
                animationSpec = tween(animationTime)
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -animationOffset },
                animationSpec = tween(animationTime)
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { animationOffset },
                animationSpec = tween(animationTime)
            )
        }
    ) {
        composable(HomeTabsRoutes.Feed.route) {
            FeedUi(feedVm = hiltViewModel())
        }
        composable(HomeTabsRoutes.Search.route) { SearchUi(searchVm = hiltViewModel()) }
        composable(HomeTabsRoutes.Bookmarks.route) { Bookmarks() }
    }
}