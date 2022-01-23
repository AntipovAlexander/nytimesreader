package ny.times.reader

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ny.times.reader.home.Home

private const val HOME = "home"

@Composable
fun AppActivityUi(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) { Home() }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppActivity()
}