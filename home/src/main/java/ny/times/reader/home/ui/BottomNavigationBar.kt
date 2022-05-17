package ny.times.reader.home.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ny.times.reader.base.theme.TimesReaderTheme
import ny.times.reader.home.navigation.BottomTabs

private val navigationItems = listOf(
    BottomTabs.Feed,
    BottomTabs.Search,
    BottomTabs.Bookmarks,
)

@Composable
fun BottomNavigationBar(homeNavController: NavHostController, modifier: Modifier = Modifier) {
    BottomNavigationBar(
        modifier = modifier,
        navBackStackEntry = homeNavController.currentBackStackEntryAsState(),
        onClick = { item ->
            homeNavController.navigate(item.route) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(homeNavController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }
        }
    )
}

@Composable
private fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    navBackStackEntry: State<NavBackStackEntry?>,
    onClick: (item: BottomTabs) -> Unit
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = TimesReaderTheme.colors.white
    ) {
        val currentDestination = navBackStackEntry.value?.destination
        navigationItems.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = stringResource(item.title)
                    )
                },
                label = { Text(stringResource(item.title)) },
                selectedContentColor = TimesReaderTheme.colors.black,
                unselectedContentColor = TimesReaderTheme.colors.black.copy(alpha = 0.4f),
                alwaysShowLabel = true,
                selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                onClick = { onClick(item) }
            )
        }
    }
}

@Composable
@Preview
private fun PreviewBottomNavigationBar() {
    BottomNavigationBar(
        modifier = Modifier,
        navBackStackEntry = remember { mutableStateOf(null) },
        onClick = {}
    )
}