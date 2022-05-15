package ny.times.reader.home.presentation.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ny.times.reader.base.theme.TimesReaderTheme
import ny.times.reader.home.navigation.BottomTabs

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    tabs: Array<BottomTabs>,
    selectedTab: BottomTabs,
    onItemClick: (BottomTabs) -> Unit
) {
    BottomNavigation(
        modifier = modifier,
        backgroundColor = TimesReaderTheme.colors.white
    ) {
        tabs.forEach { item ->
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
                selected = item == selectedTab,
                onClick = { onItemClick(item) }
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavigationBar() {
    BottomNavigationBar(
        tabs = BottomTabs.values(),
        selectedTab = BottomTabs.FEED,
        onItemClick = {}
    )
}