package ny.times.reader.home.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.widget.ViewPager2
import ny.times.reader.home.navigation.BottomTabs
import ny.times.reader.home.presentation.adapter.HomeTabsAdapter

@Composable
fun Home(fragmentManager: FragmentManager, lifecycle: Lifecycle) {
    val selectedItem = remember { mutableStateOf(BottomTabs.FEED) }
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                tabs = BottomTabs.values(),
                selectedTab = selectedItem.value,
                onItemClick = { selectedItem.value = it }
            )
        }
    ) {
        AndroidView(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = it.calculateBottomPadding()),
            factory = { context ->
                ViewPager2(context).apply {
                    adapter = HomeTabsAdapter(fragmentManager, lifecycle)
                        .apply { offscreenPageLimit = 4 }
                    isUserInputEnabled = false
                }
            },
            update = { pager -> pager.currentItem = selectedItem.value.ordinal }
        )
    }
}