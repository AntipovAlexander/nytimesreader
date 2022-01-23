package ny.times.reader.home.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ny.times.reader.feed.Feed
import ny.times.reader.search.Search

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController,
        startDestination = BottomTabs.Feed.route,
        modifier = modifier
    ) {
        composable(BottomTabs.Feed.route) { Feed() }
        composable(BottomTabs.Search.route) { Search() }
        composable(BottomTabs.Bookmarks.route) { TODO() }
    }
}