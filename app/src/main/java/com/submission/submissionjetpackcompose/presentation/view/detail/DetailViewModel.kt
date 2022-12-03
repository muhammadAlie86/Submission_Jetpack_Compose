package com.submission.submissionjetpackcompose.presentation.view.detail

import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.domain.mapper.toDomain
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class DetailViewModel  @Inject constructor(
    private val dataDummyRepository: DataDummyRepository,
) : MviViewModel<BaseViewState<DestinationViewState>, DestinationDetailEvent>() {

    override fun onTriggerEvent(eventType: DestinationDetailEvent) {
        when (eventType) {
            is DestinationDetailEvent.LoadDetail -> onLoadDetail(eventType.id)
            is DestinationDetailEvent.LoadingDestination -> startLoading()
            is DestinationDetailEvent.ErrorDestination -> handleError("Data Tidak Ditemukan")
        }
    }

    private fun onLoadDetail(id: Int) = safeLaunch {
        val params = dataDummyRepository.getDetailDestination(id)
        setState(BaseViewState.Loading)
        delay(5000L)
        setState(BaseViewState.Data(DestinationViewState(params.toDomain())))

    }
}