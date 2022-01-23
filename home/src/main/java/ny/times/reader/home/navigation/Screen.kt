package ny.times.reader.home.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ny.times.reader.home.R

const val FEED_ROUTE = "FEED_ROUTE"
const val SEARCH_ROUTE = "SEARCH_ROUTE"
const val BOOKMARKS_ROUTE = "BOOKMARKS_ROUTE"

enum class Screen(val route: String, @StringRes val title: Int, @DrawableRes val icon: Int) {
    FEED(FEED_ROUTE, R.string.feed_title, R.drawable.ic_feed),
    SEARCH(SEARCH_ROUTE, R.string.search_title, R.drawable.ic_search),
    BOOKMARKS(BOOKMARKS_ROUTE, R.string.bookmarks_title, R.drawable.ic_bookmark)
}