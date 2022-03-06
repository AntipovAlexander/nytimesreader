package ny.times.reader

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ny.times.reader.home.ui.Home
import ny.times.reader.news_details.presentation.NewsDetails

private const val HOME = "home"
private const val NEWS_DETAILS = "news_details"

@Composable
fun AppActivityUi() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = HOME) {
        composable(HOME) {
            Home {
                navController.navigate(NEWS_DETAILS)
            }
        }
        composable(NEWS_DETAILS) { NewsDetails() }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppActivity()
}