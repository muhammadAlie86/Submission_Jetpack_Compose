package com.submission.submissionjetpackcompose.presentation.view.favorite

import com.submission.submissionjetpackcompose.data.model.DestinationEntity
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationEvent

data class FavoriteState(
    val destinationDomain: List<DestinationDomain>? = null
)

sealed class FavoriteEvent {
    data class LoadFavorite(val id: Int) : FavoriteEvent()
    object ErrorFavorite: FavoriteEvent()
    object LoadingFavorite : FavoriteEvent()
    data class AddOrRemoveFavorite(val destinationDomain: DestinationDomain) : FavoriteEvent()
    object LoadFavorites : FavoriteEvent()
    data class DeleteFavorite(val id: Int) : FavoriteEvent()
}