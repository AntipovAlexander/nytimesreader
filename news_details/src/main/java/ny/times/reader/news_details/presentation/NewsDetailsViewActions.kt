package ny.times.reader.news_details.presentation

import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.news_details.presentation.entity.NewsDetailsUiModel

sealed class NewsDetailsViewActions : BaseViewAction {
    data class SetNewsDetails(val details: NewsDetailsUiModel) : NewsDetailsViewActions()
}
