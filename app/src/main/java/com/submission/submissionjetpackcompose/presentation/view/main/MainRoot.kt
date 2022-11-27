package com.submission.submissionjetpackcompose.presentation.view.main

import android.content.res.Resources
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import com.submission.submissionjetpackcompose.presentation.nav.AppNavigationProvider
import com.submission.submissionjetpackcompose.presentation.nav.NavGraphs
import com.submission.submissionjetpackcompose.shouldUseDarkMode
import com.submission.submissionjetpackcompose.ui.theme.CafeColors
import com.submission.submissionjetpackcompose.ui.theme.SubmissionJetpackComposeTheme

@Composable
fun MainRoot(finish: () -> Unit) {
    val navController = rememberNavController()

    //val isDarkMode = viewModel.themeProvider().shouldUseDarkMode()

    val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()
    val destination = currentBackStackEntryAsState?.destination?.route
        ?: NavGraphs.root.startRoute.route

    if (destination == NavGraphs.root.startRoute.route) {
        BackHandler { finish() }
    }

    SubmissionJetpackComposeTheme() {
        //SetupSystemUi(rememberSystemUiController(), CafeColors.primary)

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = CafeColors.background
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
//@Composable
//fun SetupSystemUi(
//    systemUiController: SystemUiController,
//    systemColor: Color
//) {
//    SideEffect {
//        systemUiController.setSystemBarsColor(color = systemColor)
//    }
//}