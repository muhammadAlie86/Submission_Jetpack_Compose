package com.submission.submissionjetpackcompose.presentation.view.main

import androidx.lifecycle.ViewModel
import com.submission.submissionjetpackcompose.ThemeProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class MainViewModel (private val themeProvider: ThemeProvider) : ViewModel() {

    fun themeProvider() = themeProvider
}