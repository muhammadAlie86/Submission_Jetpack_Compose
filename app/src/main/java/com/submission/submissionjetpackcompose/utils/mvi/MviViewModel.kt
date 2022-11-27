package com.submission.submissionjetpackcompose.utils.mvi

import com.submission.submissionjetpackcompose.utils.mvvm.MvvmViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class MviViewModel<STATE : BaseViewState<*>, EVENT> : MvvmViewModel() {

    private val _uiState = MutableStateFlow<BaseViewState<*>>(BaseViewState.Initiate)
    val uiState = _uiState.asStateFlow()

    abstract fun onTriggerEvent(eventType: EVENT)

    protected fun setState(state: STATE) = safeLaunch {
        _uiState.emit(state)
    }

    override fun startLoading() {
        super.startLoading()
        _uiState.value = BaseViewState.Loading
    }

    override fun handleEmpty(exception: Throwable) {
        super.handleEmpty(exception)
        _uiState.value = BaseViewState.Empty(exception)
    }

    override fun handleError(message: String) {
        super.handleError(message)
        _uiState.value = BaseViewState.Error(message)

    }
}