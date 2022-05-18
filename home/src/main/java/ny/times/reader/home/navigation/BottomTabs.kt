package ny.times.reader.home.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ny.times.reader.home.R
import ny.times.reader.navigator.home.HomeRoutes

sealed class BottomTabs(val route: String, @StringRes val title: Int, @DrawableRes val icon: Int) {
    object Feed :
        BottomTabs(HomeRoutes.Feed.route, R.string.feed_title, R.drawable.ic_feed)

    object Search :
        BottomTabs(HomeRoutes.Search.route, R.string.search_title, R.drawable.ic_search)

    object Bookmarks :
        BottomTabs(
            HomeRoutes.Bookmarks.route,
            R.string.bookmarks_title,
            R.drawable.ic_bookmark
        )
}