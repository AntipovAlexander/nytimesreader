package ny.times.reader.news_details.presentation

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.news_details.presentation.NewsDetailsFragment.Companion.UI_MODEL
import ny.times.reader.news_details.presentation.entity.NewsDetailsUiModel
import javax.inject.Inject

@HiltViewModel
class NewsDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<NewsDetailsViewState>(NewsDetailsViewState.Initial) {

    init {
        val uiModel = requireNotNull(savedStateHandle.get<NewsDetailsUiModel>(UI_MODEL))
        sendAction(NewsDetailsViewActions.SetNewsDetails(uiModel))
    }

    override fun onReduceState(viewAction: BaseViewAction) = when (viewAction) {
        is NewsDetailsViewActions.SetNewsDetails -> state.copy(details = viewAction.details)
        else -> state
    }

}