package ny.times.reader.home.ui

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import ny.times.reader.home.navigation.NavigationGraph

@Composable
fun Home(homeNavController: NavHostController) {
    Scaffold(bottomBar = { BottomNavigationBar(homeNavController) }) {
        NavigationGraph(homeNavController)
    }
}

@Preview
@Composable
fun HomePreview() {
}