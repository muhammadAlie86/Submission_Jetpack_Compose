package com.submission.submissionjetpackcompose.presentation.view.list

import com.submission.submissionjetpackcompose.domain.model.DestinationDomain

data class DestinationState (
    val listDestination : List<DestinationDomain> = emptyList()
)

sealed class DestinationEvent {
    object LoadDestination : DestinationEvent()
    object ErrorDestination : DestinationEvent()
    object LoadingDestination : DestinationEvent()
}