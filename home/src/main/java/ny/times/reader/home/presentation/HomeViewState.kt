package ny.times.reader.home.presentation

import ny.times.reader.base.presentation.view_model.BaseViewState
import ny.times.reader.home.navigation.BottomTabs

data class HomeViewState(val currentRoute: String) : BaseViewState {
    companion object {
        val INITIAL = HomeViewState(currentRoute = BottomTabs.Feed.route)
    }
}
