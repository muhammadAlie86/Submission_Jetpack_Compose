package com.submission.submissionjetpackcompose.presentation.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.navigation.DestinationDependenciesContainer
import com.ramcosta.composedestinations.scope.DestinationScope
import com.ramcosta.composedestinations.spec.Direction
import com.submission.submissionjetpackcompose.presentation.view.detail.DetailScreen

object FavoriteDetailScreenDestination : TypedDestination<FavoriteDetailScreenDestination.NavArgs> {
         
    operator fun invoke(
		id: Int = 0,
    ): Direction {
        return object : Direction {
            override val route = "$routeId" + 
					"?id=${id.toString()}"
        }
    }
    
    override val routeId = "favorite_detail_screen"

    override val route = "$routeId?id={id}"
    
	override val arguments get() = listOf(
		navArgument("id") {
			type = NavType.IntType
			defaultValue = 0
		}
	)

    @Composable
    override fun DestinationScope<NavArgs>.Content(
		dependenciesContainerBuilder: @Composable DependenciesContainerBuilder<NavArgs>.() -> Unit
    ) {
		val dependencyContainer = remember { DestinationDependenciesContainer(this) }
		dependencyContainer.apply { dependenciesContainerBuilder() }

		val (id) = navArgs
		/*DetailFavorite(
			id = id, 
			navigator = dependencyContainer.require()
		)*/
    }
                    
	override fun argsFrom(navBackStackEntry: NavBackStackEntry): NavArgs {
	    return NavArgs(
			id = navBackStackEntry.arguments?.getInt("id") ?: 0,
	    )
	}
                
	override fun argsFrom(savedStateHandle: SavedStateHandle): NavArgs {
	    return NavArgs(
			id = savedStateHandle.get<Int>("id") ?: 0,
	    )
	}

	data class NavArgs(
		val id: Int = 0,
	)
}