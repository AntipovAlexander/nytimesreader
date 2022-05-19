package ny.times.reader.home.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ny.times.reader.home.R
import ny.times.reader.navigator.home_tabs.HomeTabsRoutes

sealed class BottomTabs(val route: String, @StringRes val title: Int, @DrawableRes val icon: Int) {
    object Feed :
        BottomTabs(HomeTabsRoutes.Feed.route, R.string.feed_title, R.drawable.ic_feed)

    object Search :
        BottomTabs(HomeTabsRoutes.Search.route, R.string.search_title, R.drawable.ic_search)

    object Bookmarks :
        BottomTabs(
            HomeTabsRoutes.Bookmarks.route,
            R.string.bookmarks_title,
            R.drawable.ic_bookmark
        )
}