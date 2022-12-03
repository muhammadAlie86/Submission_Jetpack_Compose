package com.submission.submissionjetpackcompose.presentation.view.favorite

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationEvent
import com.submission.submissionjetpackcompose.presentation.view.list.DestinationState
import com.submission.submissionjetpackcompose.utils.mapper.toDestinationDomainList
import com.submission.submissionjetpackcompose.utils.mapper.toDomain
import com.submission.submissionjetpackcompose.utils.mapper.toEntity
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.mvi.MvviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val destinationRepository: DestinationRepository
): MvviViewModel<BaseViewState<FavoriteState>, FavoriteEvent>(){



    override fun onTriggerEvent(eventType: FavoriteEvent) {
        when(eventType){
            is FavoriteEvent.LoadFavorite -> onLoadFavorites()
            is FavoriteEvent.LoadingFavorite -> startLoading()
            is FavoriteEvent.ErrorFavorite -> handleError("Data Tidak Ditemukan")
            is FavoriteEvent.AddOrRemoveFavorite -> onAddOrRemoveFavorite(eventType.destinationDomain)
            is FavoriteEvent.DeleteFavorite -> onDeleteFavorite(eventType.id)
            else -> {}
        }
    }

    private fun onLoadFavorites() = safeLaunch {
        setState(BaseViewState.Loading)
        delay(5000L)
        val result = destinationRepository.getFavoriteList()
            if (result.isEmpty()) {
                setState(BaseViewState.Error("Data Tidak Ada"))
            } else {
                setState(BaseViewState.Data(FavoriteState(result.toDestinationDomainList())))
            }
        }

    private fun onAddOrRemoveFavorite(domain : DestinationDomain) = safeLaunch {
        val result = destinationRepository.getFavorite(domain.id)
        if (result == null) {
            destinationRepository.saveFavorite(domain.toEntity())
        } else {
            destinationRepository.deleteFavoriteById(domain.id)
        }
    }

    private fun onDeleteFavorite(id: Int) = safeLaunch {
        destinationRepository.deleteFavoriteById(id).also {
            onTriggerEvent(FavoriteEvent.LoadFavorites)
        }
    }

}