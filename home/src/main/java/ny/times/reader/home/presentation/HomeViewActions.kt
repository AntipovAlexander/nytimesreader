package ny.times.reader.home.presentation

import ny.times.reader.base.presentation.view_model.BaseViewAction

sealed class HomeViewActions : BaseViewAction {
    data class ChangeCurrentRoute(val route: String) : HomeViewActions()
}
