package ny.times.reader.home.presentation.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import ny.times.reader.base.domain.entity.News
import ny.times.reader.home.navigation.NavigationGraph
import ny.times.reader.home.presentation.HomeViewModel
import ny.times.reader.navigator.home.HomeRoutes

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Home(
    homeViewModel: HomeViewModel,
    onNewsClicked: (News) -> Unit
) {
    val homeNavController = rememberAnimatedNavController()

    LaunchedEffect(homeViewModel) {
        homeViewModel
            .routes
            .onEach { route -> navigate(homeNavController, route) }
            .collect()
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                modifier = Modifier,
                navBackStackEntry = homeNavController.currentBackStackEntryAsState(),
                onClick = { tab -> homeViewModel.onTabSwitched(tab) }
            )
        })
    {
        NavigationGraph(
            newsClicked = onNewsClicked,
            navController = homeNavController,
            modifier = Modifier
                .padding(bottom = it.calculateBottomPadding())
                .fillMaxWidth()
                .fillMaxHeight()
        )
    }

}

private fun navigate(navController: NavController, homeRoute: HomeRoutes) {
    navController.navigate(homeRoute.route) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        // on the back stack as users select items
        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
        // Avoid multiple copies of the same destination when
        // reselecting the same item
        launchSingleTop = true
        // Restore state when reselecting a previously selected item
        restoreState = true
    }
}