package com.submission.submissionjetpackcompose.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.submission.submissionjetpackcompose.ui.theme.Gray500
import com.submission.submissionjetpackcompose.ui.theme.White

@Composable
fun ShimmerListItem(brush: Brush) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(10.dp),
            )
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .background(White)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, top = 15.dp, bottom = 20.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .height(70.dp)
                    .width(100.dp)
                    .background(brush = brush)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 4.dp)
            ) {
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .width(100.dp)
                        .background(brush = brush)
                )
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
                Spacer(
                    modifier = Modifier
                        .height(20.dp)
                        .width(70.dp)
                        .background(brush = brush)
                )

            }

        }

    }
}