package com.submission.submissionjetpackcompose.presentation.view.home

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.submission.submissionjetpackcompose.R

enum class BottomBarHomeItem(
    @StringRes val title: Int,
    val icon: ImageVector
) {

    DESTINATION(
        title = R.string.destination,
        icon = Icons.Filled.Home
    ),
    ABOUT(
        title = R.string.about,
        icon = Icons.Filled.AccountCircle
    )
}