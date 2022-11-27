package com.submission.submissionjetpackcompose.presentation.view.list

import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.utils.datadummy.DataDummy
import com.submission.submissionjetpackcompose.utils.mapper.toDestinationDomainList
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DestinationViewModel @Inject constructor(
    dataDummy: DataDummy
): MviViewModel<BaseViewState<DestinationState>, DestinationEvent>(){


    val listDestination : List<DestinationDomain> = dataDummy.getData().toDestinationDomainList()

    override fun onTriggerEvent(eventType: DestinationEvent) {
        when(eventType){
            DestinationEvent.LoadDestination -> onLoadDestination()
        }
    }
    private fun onLoadDestination() {
        setState(BaseViewState.Loading)
        setState(BaseViewState.Data(DestinationState(listDestination)))
    }

}