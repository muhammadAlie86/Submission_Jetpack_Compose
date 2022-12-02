package com.submission.submissionjetpackcompose.presentation.view.about

import com.submission.submissionjetpackcompose.data.model.Profile
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain

data class AboutViewState(
    val profile: Profile

    )

sealed class AboutEvent {
    object LoadAbout : AboutEvent()
    object ErrorAbout : AboutEvent()
    object LoadingAbout : AboutEvent()
}