package ny.times.reader.feed.presentation

import androidx.compose.runtime.Composable
import ny.times.reader.base.presentation.BaseFragment

class FeedFragment : BaseFragment() {

    @Composable
    override fun Content() {
        Feed(newsClicked = {})
    }
}