
package com.submission.submissionjetpackcompose.presentation.view.about

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider

@Composable
fun AboutContent(viewModel: AboutViewModel,data: AboutViewState, navigator: NavigationProvider? = null) {
    LazyColumn {
        data.profile.let { profile ->
            item("contentProfileDescription") {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AboutView(viewModel = viewModel,data = profile, navigator = navigator)

                }
            }
        }
    }
}