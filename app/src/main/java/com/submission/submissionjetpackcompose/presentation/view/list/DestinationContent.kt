package com.submission.submissionjetpackcompose.presentation.view.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DestinationContent(
    viewModel: DestinationViewModel = hiltViewModel(),
    paddingValues: PaddingValues,
    viewState: DestinationState,
    selectItem: (Int) -> Unit = {}
) {
    val listCafe = viewModel.listDestination

    LazyColumn(
        contentPadding = paddingValues,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 4.dp),
    ) {
        items(listCafe.size) { index ->
            listCafe[index].let {
                DestinationRow(
                    viewModel = viewModel,
                    dto = it,
                    onDetailClick = { selectItem.invoke(it.id) }
                )
            }
        }
    }
}