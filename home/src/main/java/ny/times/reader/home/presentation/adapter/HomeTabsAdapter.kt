package ny.times.reader.home.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ny.times.reader.bookmarks.BookmarksFragment
import ny.times.reader.feed.presentation.FeedFragment
import ny.times.reader.search.presentation.SearchFragment

class HomeTabsAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> FeedFragment()
            1 -> SearchFragment()
            2 -> BookmarksFragment()
            else -> throw RuntimeException("$position is incorrect position")
        }

}