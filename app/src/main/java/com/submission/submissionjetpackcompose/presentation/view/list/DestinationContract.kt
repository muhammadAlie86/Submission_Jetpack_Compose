package com.submission.submissionjetpackcompose.presentation.view.list

import com.submission.submissionjetpackcompose.data.model.DestinationEntity
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain

data class DestinationState (
    val listDestination : List<DestinationDomain> = emptyList()
)

sealed class DestinationEvent {
    object LoadDestination : DestinationEvent()
    object ErrorDestination : DestinationEvent()
    object LoadingDestination : DestinationEvent()
    data class AddOrRemoveFavorite(val destinationDomain: DestinationDomain) : DestinationEvent()
    object LoadFavorites : DestinationEvent()
    data class DeleteFavorite(val id: Int) : DestinationEvent()
}