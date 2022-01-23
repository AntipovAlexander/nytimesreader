package ny.times.reader.home.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ny.times.reader.home.R

const val FEED_ROUTE = "FEED_ROUTE"
const val SEARCH_ROUTE = "SEARCH_ROUTE"
const val BOOKMARKS_ROUTE = "BOOKMARKS_ROUTE"

sealed class BottomTabs(val route: String, @StringRes val title: Int, @DrawableRes val icon: Int) {
    object Feed : BottomTabs(FEED_ROUTE, R.string.feed_title, R.drawable.ic_feed)

    object Search : BottomTabs(SEARCH_ROUTE, R.string.search_title, R.drawable.ic_search)

    object Bookmarks : BottomTabs(BOOKMARKS_ROUTE, R.string.bookmarks_title, R.drawable.ic_bookmark)
}