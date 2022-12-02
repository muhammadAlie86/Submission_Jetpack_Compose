package com.submission.submissionjetpackcompose.utils.mvi

import com.submission.submissionjetpackcompose.presentation.view.list.DestinationState

sealed interface BaseViewState<out T> {

    object Loading: BaseViewState<Nothing>
    object Initiate : BaseViewState<Nothing>
    data class Empty (val throwable: Throwable): BaseViewState<Nothing>
    data class Data<T>(val value: T) : BaseViewState<T>
    data class Error(val message : String) : BaseViewState<Nothing>

}