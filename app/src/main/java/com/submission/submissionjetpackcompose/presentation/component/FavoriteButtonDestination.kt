package com.submission.submissionjetpackcompose.presentation.component

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.hilt.navigation.compose.hiltViewModel
import com.submission.submissionjetpackcompose.data.model.DestinationEntity
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.view.detail.DetailViewModel
import com.submission.submissionjetpackcompose.presentation.view.favorite.FavoriteEvent
import com.submission.submissionjetpackcompose.presentation.view.favorite.FavoriteViewModel
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationEvent
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationState
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationViewModel
import com.submission.submissionjetpackcompose.ui.theme.Gray500
import com.submission.submissionjetpackcompose.ui.theme.Red
import com.submission.submissionjetpackcompose.utils.mapper.toEntity

@Composable
fun FavoriteButtonDestination(
    viewModel: DestinationViewModel = hiltViewModel(),
    dto: DestinationDomain
) {
    var isFavorite by rememberSaveable(dto) { mutableStateOf(dto.isFavorite) }
    IconButton(onClick = {
        isFavorite = !isFavorite
        dto.isFavorite = isFavorite
        viewModel.onTriggerEvent(DestinationEvent.AddOrRemoveFavorite(dto))
    }) {
        val tintColor = if (isFavorite) Red else Gray500
        Icon(
            painter = rememberVectorPainter(Icons.Default.Favorite),
            contentDescription = null,
            tint = tintColor
        )
    }
}
@Composable
fun FavoriteButtonDetail(
    viewModel: DetailViewModel = hiltViewModel(),
    dto: DestinationDomain
) {
    var isFavorite by rememberSaveable(dto) { mutableStateOf(dto.isFavorite) }

    IconButton(onClick = {
        isFavorite = !isFavorite
        dto.isFavorite = isFavorite
        //viewModel.onTriggerEvent(DestinationEvent.AddOrRemoveFavorite(dto.toEntity()))
    }) {
        val tintColor = if (isFavorite) Red else Gray500
        Icon(
            painter = rememberVectorPainter(Icons.Default.Favorite),
            contentDescription = null,
            tint = tintColor
        )
    }
}
@Composable
fun FavoriteButton(
    viewModel: FavoriteViewModel = hiltViewModel(),
    dto: DestinationDomain
) {
    var isFavorite by rememberSaveable(dto) { mutableStateOf(dto.isFavorite) }

    IconButton(onClick = {
        isFavorite = !isFavorite
        dto.isFavorite = isFavorite
        viewModel.onTriggerEvent(FavoriteEvent.AddOrRemoveFavorite(dto))
    }) {
        val tintColor = if (isFavorite) Red else Gray500
        Icon(
            painter = rememberVectorPainter(Icons.Default.Favorite),
            contentDescription = null,
            tint = tintColor
        )
    }
}
