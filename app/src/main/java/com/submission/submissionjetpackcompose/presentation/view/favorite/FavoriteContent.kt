package com.submission.submissionjetpackcompose.presentation.view.favorite

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.component.ShimmerAnimation
import com.submission.submissionjetpackcompose.presentation.component.ShimmerListItem
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState

@Composable
fun FavoriteContent(
    favors : List<DestinationDomain>,
    viewModel: FavoriteViewModel = hiltViewModel(),
    selectedFavorite: MutableState<DestinationDomain>,
    onDetailItem: (Int) -> Unit = {},
    onDeleteItem: (Int) -> Unit = {}
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp),
    ) {
        itemsIndexed(favors, key = { _, item -> item.id }) { _, favor ->
            FavoriteRow(
                dto = favor,
                onDetailClick = {
                    onDetailItem.invoke(favor.id)
                },
                onDeleteClick = {
                    selectedFavorite.value = favor
                    onDeleteItem.invoke(favor.id)
                }
            )
        }
    }
}