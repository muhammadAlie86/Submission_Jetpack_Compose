package com.submission.submissionjetpackcompose.presentation.view.about

import androidx.lifecycle.ViewModel
import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.presentation.view.detail.DestinationDetailEvent
import com.submission.submissionjetpackcompose.presentation.view.detail.DestinationViewState
import com.submission.submissionjetpackcompose.utils.mapper.toDomain
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.mvi.MvviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(
    private val dataDummyRepository: DataDummyRepository,
) : MvviViewModel<BaseViewState<AboutViewState>, AboutEvent>() {

    override fun onTriggerEvent(eventType: AboutEvent) {
        when (eventType) {
            is AboutEvent.LoadAbout -> onLoadAbout()
            is AboutEvent.LoadingAbout -> startLoading()
            is AboutEvent.ErrorAbout -> handleError("Data Tidak Ditemukan")
        }
    }


    private fun onLoadAbout() = safeLaunch {
        val profile = dataDummyRepository.getProfile()
        setState(BaseViewState.Loading)
        delay(5000L)
        setState(BaseViewState.Data(AboutViewState(profile)))

    }

}
