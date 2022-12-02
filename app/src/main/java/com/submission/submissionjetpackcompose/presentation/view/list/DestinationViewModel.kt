package com.submission.submissionjetpackcompose.presentation.view.list

import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.utils.mapper.toDestinationDomainList
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.mvi.MvviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(
    private val dataDummyRepository: DataDummyRepository
): MvviViewModel<BaseViewState<DestinationState>,DestinationEvent>(){



    override fun onTriggerEvent(eventType: DestinationEvent) {
        when(eventType){
            DestinationEvent.LoadDestination -> onLoadDestination()
            DestinationEvent.LoadingDestination -> startLoading()
            DestinationEvent.ErrorDestination -> handleError("Data Tidak Ditemukan")
        }
    }
    private fun onLoadDestination() = safeLaunch{
        val listDestination = dataDummyRepository.getDestinationList()
        setState(BaseViewState.Loading)
        delay(5000L)
        setState(BaseViewState.Data(DestinationState(listDestination.toDestinationDomainList())))
    }

}