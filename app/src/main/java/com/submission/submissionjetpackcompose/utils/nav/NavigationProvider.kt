package com.submission.submissionjetpackcompose.utils.nav

interface NavigationProvider {
    fun openDestinationDetail(id: Int)
    fun openFavoriteDetail(favoriteId: Int)
    fun openAbout()
    fun navigateUp()
}