package com.submission.submissionjetpackcompose.presentation.nav

import com.submission.submissionjetpackcompose.utils.NavGraph


object NavGraphs {

    val root = NavGraph(
        route = "root",
        startRoute = HomeScreenDestination,
        destinations = listOf(
			DestinationScreenDestination,
			HomeScreenDestination,
			DestinationDetailScreenDestination,
			AboutScreenDestination,
			FavoriteDetailScreenDestination
        )
    )
}