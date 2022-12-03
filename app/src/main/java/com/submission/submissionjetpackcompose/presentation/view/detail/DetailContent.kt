
package com.submission.submissionjetpackcompose.presentation.view.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider

@Composable
fun DetailContent(viewModel: DetailViewModel,data: DestinationViewState, navigator: NavigationProvider? = null) {
    LazyColumn {
        data.destinationDomain?.let { destination ->
            item("contentDescription") {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DetailDestinationView(viewModel = viewModel,dto = destination, navigator = navigator)

                }
            }
        }
    }
}