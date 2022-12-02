package com.submission.submissionjetpackcompose.utils.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

abstract class MvviViewModel<STATE : BaseViewState<*>, EVENT> : ViewModel() {

    private val _uiState = MutableStateFlow<BaseViewState<*>>(BaseViewState.Initiate)
    val uiState = _uiState.asStateFlow()

    abstract fun onTriggerEvent(eventType: EVENT)

    private val handler = CoroutineExceptionHandler { _, exception ->
        handleEmpty(exception)
    }
   fun safeLaunch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(handler, block = block)
    }

    protected fun setState(state: STATE) = safeLaunch {
        _uiState.emit(state)
    }

    fun startLoading() {
        _uiState.value = BaseViewState.Loading
    }

    fun handleEmpty(exception: Throwable) {
        _uiState.value = BaseViewState.Empty(exception)
    }

    fun handleError(message: String) {
        _uiState.value = BaseViewState.Error(message)

    }
}