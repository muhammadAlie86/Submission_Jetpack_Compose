package com.submission.submissionjetpackcompose.utils

import androidx.navigation.NavBackStackEntry
import com.ramcosta.composedestinations.spec.*
import com.ramcosta.composedestinations.utils.startDestinationSpec
import com.ramcosta.composedestinations.utils.destinationSpec
import com.submission.submissionjetpackcompose.presentation.nav.Destination
import com.submission.submissionjetpackcompose.presentation.nav.NavGraphs

data class NavGraph(
    override val route: String,
    override val startRoute: Route,
    val destinations: List<Destination>,
    override val nestedNavGraphs: List<NavGraph> = emptyList()
): NavGraphSpec {
    override val destinationsByRoute: Map<String, Destination> = destinations.associateBy { it.route }
}

/**
 * Finds the destination correspondent to this [NavBackStackEntry] in [navGraph], null if none is found
 * or if no route is set in this back stack entry's destination.
 */
fun NavBackStackEntry.navDestination(navGraph: NavGraph = NavGraphs.root): Destination {
    return destinationSpec(navGraph) as Destination
}