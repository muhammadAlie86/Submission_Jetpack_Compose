package com.submission.submissionjetpackcompose.presentation.view.list

import com.submission.submissionjetpackcompose.domain.model.DestinationDomain

data class DestinationState (
    val listCafe : List<DestinationDomain> = emptyList()
)

sealed class DestinationEvent {
    object LoadDestination : DestinationEvent()
}