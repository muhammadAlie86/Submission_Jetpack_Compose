package com.submission.submissionjetpackcompose.presentation.view.about

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.submission.submissionjetpackcompose.R
import com.submission.submissionjetpackcompose.presentation.component.*
import com.submission.submissionjetpackcompose.utils.base.cast
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider

@Composable
fun AboutScreen(
    modifier: Modifier = Modifier,
    viewModel: AboutViewModel = hiltViewModel(),
    navigator: NavigationProvider
) {
    val uiState by viewModel.uiState.collectAsState()
    AboutBody {
        when (uiState) {
            is BaseViewState.Data -> AboutContent(
                viewModel = viewModel,
                data = uiState.cast<BaseViewState.Data<AboutViewState>>().value,
                navigator = navigator
            )
            is BaseViewState.Empty -> EmptyView()
            is BaseViewState.Error -> ErrorView(
                e = uiState.cast<BaseViewState.Error>().message,
                action = {
                    viewModel.onTriggerEvent(AboutEvent.LoadAbout)
                }
            )
            is BaseViewState.Loading -> repeat(5) {
                ShimmerAnimation {
                    ShimmerAbout(brush = it)
                }
            }
            else -> {}
        }
    }

        LaunchedEffect(key1 = viewModel, block = {
            viewModel.onTriggerEvent(AboutEvent.LoadAbout)
        })

    }



@Composable
private fun AboutBody(
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
             R.string.about
        },
        content = { content.invoke(it) }
    )
}