package ny.times.reader.home.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ny.times.reader.home.R

enum class BottomTabs(@StringRes val title: Int, @DrawableRes val icon: Int) {
    FEED(R.string.feed_title, R.drawable.ic_feed),
    SEARCH(R.string.search_title, R.drawable.ic_search),
    BOOKMARKS(R.string.bookmarks_title, R.drawable.ic_bookmark)
}