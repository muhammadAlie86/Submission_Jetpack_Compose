package com.submission.submissionjetpackcompose.utils.nav

interface NavigationProvider {
    fun openCafeDetail(favoriteId: Int)
    fun openFavoriteDetail(favoriteId: Int)
    fun openAbout()
    fun navigateUp()
}