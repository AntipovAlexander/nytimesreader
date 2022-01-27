package ny.times.reader.base.presentation.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

abstract class BaseViewModel<ViewState : BaseViewState>(initialState: ViewState) : ViewModel() {

    var state by mutableStateOf<ViewState>(initialState)
        private set

    protected abstract fun onReduceState(viewAction: BaseViewAction): ViewState

    protected fun sendActions(vararg actions: BaseViewAction) = actions.forEach(::sendAction)

    protected fun sendAction(action: BaseViewAction) {
        viewModelScope.launch { state = onReduceState(action) }
    }

}

