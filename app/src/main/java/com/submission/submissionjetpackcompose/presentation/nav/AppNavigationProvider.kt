package com.submission.submissionjetpackcompose.presentation.nav

import androidx.navigation.NavController
import com.ramcosta.composedestinations.navigation.navigateTo
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider

class AppNavigationProvider constructor(
    private val navController: NavController
) : NavigationProvider {

    override fun openDestinationDetail(id: Int) {
        navController.navigateTo(DestinationDetailScreenDestination(id))
    }

    override fun openFavoriteDetail(favoriteId: Int) {
        navController.navigateTo(FavoriteDetailScreenDestination(favoriteId))
    }

    override fun openAbout() {
        navController.navigateTo(AboutScreenDestination())
    }


    override fun navigateUp() {
        navController.navigateUp()
    }
}