package com.submission.submissionjetpackcompose.presentation.nav

import com.submission.submissionjetpackcompose.utils.NavGraph


object NavGraphs {

    val root = NavGraph(
        route = "root",
        startRoute = SplashScreenDestination,
        destinations = listOf(
			DestinationScreen,
			HomeScreenDestination,
			DestinationDetailScreenDestination,
			AboutScreenDestination,
            SplashScreenDestination
        )
    )
}