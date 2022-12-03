package com.submission.submissionjetpackcompose.presentation.view.about

import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import com.submission.submissionjetpackcompose.utils.mvi.MviViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor(
    private val dataDummyRepository: DataDummyRepository,
) : MviViewModel<BaseViewState<AboutViewState>, AboutEvent>() {

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
