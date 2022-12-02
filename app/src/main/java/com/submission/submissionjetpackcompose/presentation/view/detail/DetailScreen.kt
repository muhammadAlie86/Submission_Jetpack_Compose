package com.submission.submissionjetpackcompose.presentation.view.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.submission.submissionjetpackcompose.R
import com.submission.submissionjetpackcompose.presentation.component.DestinationToolbarWithNavIcon
import com.submission.submissionjetpackcompose.presentation.component.DialogBoxLoadingView
import com.submission.submissionjetpackcompose.presentation.component.EmptyView
import com.submission.submissionjetpackcompose.presentation.component.ErrorView
import com.submission.submissionjetpackcompose.utils.base.cast
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider

@Composable
fun DetailScreen(
    id: Int = 0,
    viewModel : DetailViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {

    val uiState by viewModel.uiState.collectAsState()

    DetailBody{
        DetailBody(pressOnBack = {
            navigator.navigateUp()
        }) {
            when (uiState) {
                is BaseViewState.Data -> DetailContent(
                    viewModel = viewModel,
                    data = uiState.cast<BaseViewState.Data<DestinationViewState>>().value,
                    navigator = navigator
                )
                is BaseViewState.Empty -> EmptyView()
                is BaseViewState.Error -> ErrorView(
                    e = uiState.cast<BaseViewState.Error>().message,
                    action = {
                        viewModel.onTriggerEvent(DestinationDetailEvent.LoadDetail(id))
                    }
                )
                is BaseViewState.Loading -> DialogBoxLoadingView()
                else -> {}
            }
        }

        LaunchedEffect(key1 = viewModel, block = {
            viewModel.onTriggerEvent(DestinationDetailEvent.LoadDetail(id))
        })
    }

}
@Composable
private fun DetailBody(
    pressOnBack: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
                 DestinationToolbarWithNavIcon(titleResId = R.string.toolbar_detail_title) {
                     pressOnBack()
                 }
        },
        content = { content.invoke(it) }
    )
}