package ny.times.reader.feed.presentation

import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ny.times.reader.base.presentation.BaseFragment
import ny.times.reader.feed.presentation.ui.FeedUi

@AndroidEntryPoint
class FeedFragment : BaseFragment() {

    private val feedViewModel by viewModels<FeedViewModel>()

    @Composable
    override fun Content() {
        FeedUi(
            chips = feedViewModel.state.chips,
            contentState = feedViewModel.state.contentState,
            paginationInProgress = feedViewModel.state.paginationInProgress,
            newsClicked = { id ->
                val item = feedViewModel.getById(id) ?: return@FeedUi
                // todo: navigation should be here
            },
            chipClicked = feedViewModel::chipSelected,
            lastVisibleItemChanged = feedViewModel::lastVisibleItemChanged,
            retryClicked = feedViewModel::retryClicked
        )
    }
}