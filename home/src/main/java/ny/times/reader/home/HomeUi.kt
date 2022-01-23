package ny.times.reader.home

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ny.times.reader.home.navigation.Screen
import ny.times.reader.theme.TimesReaderTheme

@Composable
fun Home() {
    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = TimesReaderTheme.colors.white
            ) {
                Screen.values().forEach { item ->
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
                        selected = false,
                        onClick = {
                            /* Add code later */
                        }
                    )
                }
            }
        }
    ) {

    }
}

@Preview
@Composable
fun HomePreview() {
    Home()
}