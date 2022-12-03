package com.submission.submissionjetpackcompose.presentation.view.list

import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.view.favorite.FavoriteState
import com.submission.submissionjetpackcompose.utils.mapper.toDestinationDomainList
import com.submission.submissionjetpackcompose.utils.mapper.toDomain
import com.submission.submissionjetpackcompose.utils.mapper.toEntity
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.mvi.MvviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val dataDummyRepository: DataDummyRepository,
    private val destinationRepository: DestinationRepository
): MvviViewModel<BaseViewState<DestinationState>,DestinationEvent>(){



    override fun onTriggerEvent(eventType: DestinationEvent) {
        when(eventType){
            is DestinationEvent.LoadDestination -> onLoadDestination()
            is DestinationEvent.LoadingDestination -> startLoading()
            is DestinationEvent.ErrorDestination -> handleError("Data Tidak Ditemukan")
            is DestinationEvent.AddOrRemoveFavorite -> onAddOrRemoveFavorite(eventType.destinationDomain)
            is DestinationEvent.DeleteFavorite -> onDeleteFavorite(eventType.id)
            is DestinationEvent.LoadFavorites -> onLoadFavorites()
            else -> {}
        }
    }
    private fun onLoadDestination() = safeLaunch{
        val listDestination = dataDummyRepository.getDestinationList()
        setState(BaseViewState.Loading)
        delay(5000L)
        setState(BaseViewState.Data(DestinationState(listDestination.toDestinationDomainList())))
    }
    private fun onAddOrRemoveFavorite(dto: DestinationDomain) = safeLaunch {
        val destination = destinationRepository.getFavorite(dto.id)
        if (destination == null) {
            destinationRepository.saveFavorite(dto.toEntity())
        } else {
            destinationRepository.deleteFavoriteById(dto.id)
        }
    }

    private fun onLoadFavorites() = safeLaunch {
        val result = destinationRepository.getFavoriteList()
            if (result.isEmpty()) {
                setState(BaseViewState.Error("Data not Found"))
            } else {
                setState(BaseViewState.Data(DestinationState(result.toDestinationDomainList())))
            }
        }


    private fun onDeleteFavorite(id: Int) = safeLaunch {
        destinationRepository.deleteFavoriteById(id).also {
            onTriggerEvent(DestinationEvent.LoadFavorites)
        }
    }

}