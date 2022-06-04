package ny.times.reader.home.presentation.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import ny.times.reader.home.navigation.NavigationGraph
import ny.times.reader.home.presentation.HomeTabsViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Home(homeViewModel: HomeTabsViewModel) {
    val homeNavController = rememberAnimatedNavController()

    LaunchedEffect(homeViewModel) { homeNavController.attachRouter(homeViewModel.router) }

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
            navController = homeNavController,
            modifier = Modifier
                .padding(bottom = it.calculateBottomPadding())
                .fillMaxWidth()
                .fillMaxHeight()
        )
    }

}
