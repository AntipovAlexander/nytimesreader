package ny.times.reader.news_details.presentation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ny.times.reader.base.presentation.BaseFragment
import ny.times.reader.news_details.presentation.entity.NewsDetailsUiModel
import ny.times.reader.news_details.presentation.ui.NewsDetailsUi

@AndroidEntryPoint
class NewsDetailsFragment : BaseFragment() {

    companion object {
        internal const val UI_MODEL =
            "ny.times.reader.news_details.presentation.NewsDetailsFragment.UI_MODEL"

        fun newInstance(newsDetailsUiModel: NewsDetailsUiModel): NewsDetailsFragment {
            val args = Bundle().apply { putParcelable(UI_MODEL, newsDetailsUiModel) }
            return NewsDetailsFragment().apply { arguments = args }
        }
    }

    private val homeViewModel by viewModels<NewsDetailsViewModel>()

    @Composable
    override fun Content() = NewsDetailsUi(homeViewModel.state.details)
}