package ny.times.reader.news_details.presentation

import ny.times.reader.base.presentation.view_model.BaseViewState
import ny.times.reader.news_details.presentation.entity.NewsDetailsUiModel

data class NewsDetailsViewState(
    val details: NewsDetailsUiModel
) : BaseViewState {
    companion object {
        val Initial = NewsDetailsViewState(
            details = NewsDetailsUiModel.EMPTY
        )
    }
}
