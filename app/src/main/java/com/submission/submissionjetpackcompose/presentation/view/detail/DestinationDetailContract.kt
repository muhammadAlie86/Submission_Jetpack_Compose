package com.submission.submissionjetpackcompose.presentation.view.detail

import com.submission.submissionjetpackcompose.domain.model.DestinationDomain

data class DestinationViewState(
    val destinationDomain: DestinationDomain? = null
)

sealed class DestinationDetailEvent {
    data class LoadDetail(val id: Int) : DestinationDetailEvent()
    object ErrorDestination : DestinationDetailEvent()
    object LoadingDestination : DestinationDetailEvent()
}