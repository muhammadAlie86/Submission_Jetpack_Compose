package com.submission.submissionjetpackcompose.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerAbout(brush: Brush) {

    Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
        Spacer(
            modifier = Modifier
                .height(300.dp)
                .width(400.dp)
                .background(brush = brush)
        )

        Spacer(
            modifier = Modifier.padding(10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .width(100.dp)
                    .background(brush = brush)
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .width(100.dp)
                    .background(brush = brush)
            )


            Spacer(
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
        Spacer(
            modifier = Modifier.padding(10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .width(100.dp)
                    .background(brush = brush)
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .width(100.dp)
                    .background(brush = brush)
            )


            Spacer(
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }
        Spacer(
            modifier = Modifier.padding(10.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .width(100.dp)
                    .background(brush = brush)
            )

            Spacer(
                modifier = Modifier
                    .height(20.dp)
                    .width(100.dp)
                    .background(brush = brush)
            )


            Spacer(
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }

    }
}