package com.submission.submissionjetpackcompose.presentation.view.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.submission.submissionjetpackcompose.R
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.component.DestinationToolbar
import com.submission.submissionjetpackcompose.presentation.component.EmptyView
import com.submission.submissionjetpackcompose.presentation.component.ErrorView
import com.submission.submissionjetpackcompose.presentation.component.LoadingView
import com.submission.submissionjetpackcompose.presentation.view.favorite.FavoriteBottomSheetContent
import com.submission.submissionjetpackcompose.ui.theme.CafeColors
import com.submission.submissionjetpackcompose.utils.base.cast
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DestinationScreen(
    modifier: Modifier = Modifier,
    viewModel: DestinationViewModel = hiltViewModel(),
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
    navigator: NavigationProvider
) {

    val uiState by viewModel.uiState.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val selectedFavorite = remember { mutableStateOf(DestinationDomain()) }

    DestinationsBody(
        modifier, bottomSheetState,
        sheetContent = {
            FavoriteBottomSheetContent(
                character = selectedFavorite.value,
                onCancel = {
                    coroutineScope.launch {
                        bottomSheetState.hide()
                    }
                },
                onApprove = {
                    coroutineScope.launch {
                        //viewModel.onTriggerEvent(CharactersEvent.DeleteFavorite(selectedFavorite.value.id.orZero()))
                        bottomSheetState.hide()
                    }
                }
            )
        }
    ) { padding ->
        Column {
            DestinationPage(uiState, viewModel, padding, navigator, modifier)
        }
    }
}

@Composable
private fun DestinationPage(
    uiState: BaseViewState<*>,
    viewModel: DestinationViewModel,
    paddings: PaddingValues,
    navigator: NavigationProvider,
    modifier: Modifier
) {
    when (uiState) {
        is BaseViewState.Data -> DestinationContent(
            viewModel = viewModel,
            paddingValues = PaddingValues(5.dp),
            viewState = uiState.cast<BaseViewState.Data<DestinationState>>().value,
            selectItem = { id -> navigator.openCafeDetail(id) }
        )
        is BaseViewState.Empty -> EmptyView(modifier = modifier)
        is BaseViewState.Error -> ErrorView(
            e = uiState.cast<BaseViewState.Error>().message
        ) {
            viewModel.onTriggerEvent(DestinationEvent.LoadDestination)
        }
        is BaseViewState.Loading -> LoadingView()
        else -> {}
    }

    LaunchedEffect(key1 = viewModel, block = {
        viewModel.onTriggerEvent(DestinationEvent.LoadDestination)
    })
}



@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun DestinationsBody(
    modifier: Modifier = Modifier,
    bottomSheetState: ModalBottomSheetState,
    sheetContent: @Composable ColumnScope.() -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    ModalBottomSheetLayout(
        sheetContent = sheetContent,
        modifier = modifier
            .fillMaxSize(),
        sheetState = bottomSheetState,
        sheetContentColor = CafeColors.background,
        sheetShape = RectangleShape,
        content = {
            Scaffold(
                topBar = { DestinationToolbar(R.string.destination, elevation = 0.dp) },
                content = { content.invoke(it) }
            )
        }
    )
}