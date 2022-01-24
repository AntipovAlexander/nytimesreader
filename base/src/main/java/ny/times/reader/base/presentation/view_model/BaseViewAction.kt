package ny.times.reader.base.presentation.view_model

interface BaseViewAction {
    class ShowProgress(val inProgress: Boolean) : BaseViewAction
}
