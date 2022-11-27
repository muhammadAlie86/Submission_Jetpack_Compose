package com.submission.submissionjetpackcompose.presentation.component

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.submission.submissionjetpackcompose.presentation.nav.Destination
import com.submission.submissionjetpackcompose.ui.theme.CafeColors
import com.submission.submissionjetpackcompose.ui.theme.CafeTypography
import com.submission.submissionjetpackcompose.ui.theme.navigationBackIconColor


@Composable
fun DestinationToolbar(
    @StringRes titleResId: Int,
    elevation: Dp = AppBarDefaults.TopAppBarElevation
) {
    TopAppBar(
        title = {
            Text(
                stringResource(titleResId),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = CafeTypography.h2
            )
        },
        backgroundColor = CafeColors.primary,
        modifier = Modifier.fillMaxWidth(),
        elevation = elevation
    )
}

@Composable
fun DestinationToolbarWithNavIcon(
    @StringRes titleResId: Int,
    pressOnBack: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                stringResource(titleResId),
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth(),
                style = CafeTypography.h2
            )
        },
        navigationIcon = {
            Icon(
                rememberVectorPainter(Icons.Filled.ArrowBack),
                contentDescription = null,
                tint =  CafeColors.navigationBackIconColor,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { pressOnBack.invoke() }
            )
        },
        backgroundColor =  CafeColors.primary,
        modifier = Modifier.fillMaxWidth()
    )
}