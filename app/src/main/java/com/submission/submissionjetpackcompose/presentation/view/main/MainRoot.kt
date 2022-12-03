package com.submission.submissionjetpackcompose.presentation.view.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.submission.submissionjetpackcompose.presentation.nav.AppNavigationProvider
import com.submission.submissionjetpackcompose.presentation.nav.NavGraphs
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationScreen
import com.submission.submissionjetpackcompose.ui.theme.DestinationColors
import com.submission.submissionjetpackcompose.ui.theme.SubmissionJetpackComposeTheme

@Composable
fun MainRoot(finish: () -> Unit) {
    val navController = rememberNavController()


    val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()
    val destination = currentBackStackEntryAsState?.destination?.route
        ?: NavGraphs.root.startRoute.route

    if (destination == NavGraphs.root.startRoute.route) {
        BackHandler { finish() }
    }

    SubmissionJetpackComposeTheme() {

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = DestinationColors.background
        ) {
            DestinationsNavHost(
                navController = navController,
                navGraph = NavGraphs.root,
                dependenciesContainerBuilder = {
                    dependency(AppNavigationProvider(navController))
                }
            )
        }
    }
}