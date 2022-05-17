package ny.times.reader.home.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import ny.times.reader.base.domain.entity.News
import ny.times.reader.home.navigation.NavigationGraph

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Home(onNewsClicked: (News) -> Unit) {
    val homeNavController = rememberAnimatedNavController()
    Scaffold(bottomBar = { BottomNavigationBar(homeNavController) }) {
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