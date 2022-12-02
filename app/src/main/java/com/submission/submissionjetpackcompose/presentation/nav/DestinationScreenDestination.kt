package com.submission.submissionjetpackcompose.presentation.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer
import com.ramcosta.composedestinations.scope.DestinationScope
import com.submission.submissionjetpackcompose.presentation.view.about.AboutScreen

object DestinationScreenDestination : DirectionDestination {
         
    operator fun invoke() = this
    
    override val routeId = "destination_screen"

    override val route = routeId
    
    @Composable
    override fun DestinationScope<Unit>.Content(
		dependenciesContainerBuilder: @Composable DependenciesContainerBuilder<Unit>.() -> Unit
    ) {
		val dependencyContainer = remember { DestinationDependenciesContainer(this) }
		dependencyContainer.apply { dependenciesContainerBuilder() }

		AboutScreen(
			navigator = dependencyContainer.require()
		)
    }
    
}