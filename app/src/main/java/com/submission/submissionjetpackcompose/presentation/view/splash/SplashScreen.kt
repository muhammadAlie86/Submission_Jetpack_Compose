package com.submission.submissionjetpackcompose.presentation.view.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.submission.submissionjetpackcompose.R
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider
import kotlinx.coroutines.delay

@Destination(start = true)
@Composable
fun SplashScreen(
    navigator : NavigationProvider,
) {

    LaunchedEffect(key1 = true){
        delay(5000L)
        navigator.openHome()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .sizeIn(240.dp, 100.dp),
            painter = painterResource(id = R.drawable.ic_splash),
            contentDescription = null
        )
    }


}
