package ny.times.reader.news_details.presentation

import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.news_details.presentation.argument.NewsDetailsUiModel

sealed class NewsDetailsViewActions : BaseViewAction {
    data class SetNewsDetails(val details: NewsDetailsUiModel) : NewsDetailsViewActions()
}
