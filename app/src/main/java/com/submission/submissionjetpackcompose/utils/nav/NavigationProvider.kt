package com.submission.submissionjetpackcompose.utils.nav

interface NavigationProvider {
    fun openDestinationDetail(id: Int)
    fun openHome()
    fun openAbout()
    fun navigateUp()
}