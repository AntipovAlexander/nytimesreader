package ny.times.reader.home.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import ny.times.reader.home.navigation.NavigationGraph

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Home() {
    val homeNavController = rememberAnimatedNavController()
    Scaffold(bottomBar = { BottomNavigationBar(homeNavController) }) {
        NavigationGraph(homeNavController, modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight())
    }
}

@Preview
@Composable
fun HomePreview() {
}