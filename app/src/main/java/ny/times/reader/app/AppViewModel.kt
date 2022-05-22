package ny.times.reader.app

import dagger.hilt.android.lifecycle.HiltViewModel
import ny.times.reader.base.domain.entity.News
import ny.times.reader.base.presentation.view_model.BaseViewAction
import ny.times.reader.base.presentation.view_model.BaseViewModel
import ny.times.reader.base.presentation.view_model.BaseViewState
import ny.times.reader.navigator.app.AppNavigation
import ny.times.reader.navigator.app.AppRouter
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val appNavigation: AppNavigation,
    private val appRouter: AppRouter
) : BaseViewModel<AppViewModel.HomeViewState>(HomeViewState),
    AppRouter by appRouter,
    AppNavigation by appNavigation {

    override fun onReduceState(viewAction: BaseViewAction): HomeViewState = state

    fun onNewsDetailsClicked(news: News) = appNavigation.navigateToNewsDetails(
        headline = news.title,
        abstract = news.snippet,
        leadParagraph = news.leadParagraph,
        image = news.imageUrl,
        sourceName = news.source,
        sourceUrl = news.url,
        tags = news.keywords.toTypedArray()
    )

    object HomeViewState : BaseViewState
}