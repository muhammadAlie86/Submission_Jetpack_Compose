package com.submission.submissionjetpackcompose.presentation.view.list

import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.domain.mapper.toDestinationDomainList
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val dataDummyRepository: DataDummyRepository
): MviViewModel<BaseViewState<DestinationState>,DestinationEvent>(){



    override fun onTriggerEvent(eventType: DestinationEvent) {
        when(eventType){
            is DestinationEvent.LoadDestination -> onLoadDestination()
            is DestinationEvent.LoadingDestination -> startLoading()
            is DestinationEvent.ErrorDestination -> handleError("Data Tidak Ditemukan")

        }
    }
    private fun onLoadDestination() = safeLaunch{
        val listDestination = dataDummyRepository.getDestinationList()
        setState(BaseViewState.Loading)
        delay(5000L)
        setState(BaseViewState.Data(DestinationState(listDestination.toDestinationDomainList())))
    }


}