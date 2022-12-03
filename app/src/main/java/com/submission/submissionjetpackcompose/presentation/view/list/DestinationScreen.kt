package com.submission.submissionjetpackcompose.presentation.view.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.submission.submissionjetpackcompose.R
import com.submission.submissionjetpackcompose.presentation.component.*
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.mvi.cast
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider

@Composable
fun DestinationScreen(
    modifier: Modifier = Modifier,
    viewModel: DestinationViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {

    val uiState by viewModel.uiState.collectAsState()


    DestinationBody {

        when (uiState) {
            is BaseViewState.Data -> DestinationContent(
                viewModel = viewModel,
                paddingValues = PaddingValues(5.dp),
                viewState = uiState.cast<BaseViewState.Data<DestinationState>>().value,
                selectItem = { id -> navigator.openDestinationDetail(id) }
            )
            is BaseViewState.Empty -> EmptyView(modifier = modifier)
            is BaseViewState.Error -> ErrorView(
                e = uiState.cast<BaseViewState.Error>().message
            ) {
                viewModel.onTriggerEvent(DestinationEvent.LoadDestination)
            }
            is BaseViewState.Loading -> {
                LazyColumn {
                    item {
                        repeat(5) {
                            ShimmerAnimation {
                                ShimmerListItem(brush = it)
                            }
                        }
                    }
                }
            }
            else -> {}
        }

        LaunchedEffect(key1 = viewModel, block = {
            viewModel.onTriggerEvent(DestinationEvent.LoadDestination)
        })

    }

}



@Composable
private fun DestinationBody(
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            DestinationToolbar(titleResId = R.string.destination)
        },
        content = { content.invoke(it) }
    )
}