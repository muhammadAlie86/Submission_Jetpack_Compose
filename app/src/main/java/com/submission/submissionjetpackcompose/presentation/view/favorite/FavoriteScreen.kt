package com.submission.submissionjetpackcompose.presentation.view.favorite

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
import com.submission.submissionjetpackcompose.presentation.component.DialogBoxLoadingView
import com.submission.submissionjetpackcompose.presentation.component.EmptyView
import com.submission.submissionjetpackcompose.presentation.component.ErrorView
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationContent
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationEvent
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationState
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationViewModel
import com.submission.submissionjetpackcompose.ui.theme.CafeColors
import com.submission.submissionjetpackcompose.utils.base.cast
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
    viewModel: FavoriteViewModel = hiltViewModel(),
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
    navigator: NavigationProvider
) {

    val uiState by viewModel.uiState.collectAsState()

    val coroutineScope = rememberCoroutineScope()
    val selectedFavorite = remember { mutableStateOf(DestinationDomain()) }

    FavoritesBody(
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
                        viewModel.onTriggerEvent(FavoriteEvent.DeleteFavorite(selectedFavorite.value.id))
                        bottomSheetState.hide()
                    }
                }
            )
        }
    ) { padding ->
        Column {
            FavoritesPage(
                coroutineScope,
                bottomSheetState,
                uiState,
                viewModel,
                navigator,
                modifier,
                selectedFavorite
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun FavoritesPage(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    bottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden),
    uiState: BaseViewState<*>,
    viewModel: FavoriteViewModel,
    navigator: NavigationProvider,
    modifier: Modifier,
    selectedFavorite: MutableState<DestinationDomain>
) {
    when (uiState) {
        is BaseViewState.Data -> uiState.cast<BaseViewState.Data<FavoriteState>>().value.destinationDomain?.let {
            FavoriteContent(
                favors = it,
                selectedFavorite = selectedFavorite,
                onDetailItem = { id -> navigator.openFavoriteDetail(id) },
                onDeleteItem = {
                    coroutineScope.launch {
                        if (bottomSheetState.isVisible) {
                            bottomSheetState.hide()
                        } else {
                            bottomSheetState.show()
                        }
                    }
                }
            )
        }
        is BaseViewState.Empty -> EmptyView(modifier = modifier)
        is BaseViewState.Error -> ErrorView(
            e = uiState.cast<BaseViewState.Error>().message
        ) {
            viewModel.onTriggerEvent(FavoriteEvent.LoadFavorites)
        }
        is BaseViewState.Loading -> DialogBoxLoadingView()
        else -> {
            DialogBoxLoadingView()}
    }

    LaunchedEffect(key1 = viewModel, block = {
        viewModel.onTriggerEvent(FavoriteEvent.LoadFavorites)
    })
}



@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun FavoritesBody(
    modifier: Modifier = Modifier,
    bottomSheetState: ModalBottomSheetState,
    sheetContent: @Composable ColumnScope.() -> Unit,
    pageContent: @Composable (PaddingValues) -> Unit
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
                topBar = { DestinationToolbar(R.string.favorite, elevation = 0.dp) },
                content = { pageContent.invoke(it) }
            )
        }
    )
}