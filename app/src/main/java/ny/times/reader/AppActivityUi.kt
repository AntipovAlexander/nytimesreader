package ny.times.reader

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ny.times.reader.home.ui.Home

private const val HOME = "home"

@Composable
fun AppActivityUi() {
    val navController = rememberNavController()
    val bottomBarController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) { Home(bottomBarController) }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppActivity()
}