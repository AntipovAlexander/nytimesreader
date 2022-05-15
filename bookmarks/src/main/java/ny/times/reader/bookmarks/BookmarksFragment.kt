package ny.times.reader.bookmarks

import androidx.compose.runtime.Composable
import ny.times.reader.base.presentation.BaseFragment

class BookmarksFragment : BaseFragment() {

    @Composable
    override fun Content() = BookmarksUi()
}