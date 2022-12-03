package com.submission.submissionjetpackcompose.presentation.view.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.submission.submissionjetpackcompose.presentation.component.ShimmerAnimation
import com.submission.submissionjetpackcompose.presentation.component.ShimmerListItem

@Composable
fun DestinationContent(
    viewModel: DestinationViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    viewState: DestinationState,
    selectItem: (Int) -> Unit = {}
) {
    val listDestination = remember{ viewState.listDestination }
    LazyColumn(
        contentPadding = paddingValues,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 50.dp),
    ) {
        items(listDestination.count()) { index ->
            DestinationRow(
                viewModel = viewModel,
                dto = listDestination[index],
                onDetailClick = { selectItem.invoke(index) }
            )
        }

    }
}