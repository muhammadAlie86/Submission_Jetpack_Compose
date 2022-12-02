package com.submission.submissionjetpackcompose.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
    Column(
        modifier = Modifier
            .padding(horizontal = 15.dp, vertical = 10.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(20.dp),
            )
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .background(White)
    ) {
        Row(
            modifier = Modifier
                .padding(start = 20.dp, top = 15.dp)
        ) {
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(70.dp)
                .background(brush =  brush)
            )
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(70.dp)
                .background(brush =  brush)
            )
        }

        Row(
            modifier = Modifier
                .padding(start = 40.dp, top = 5.dp)
        ) {
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(70.dp)
                .background(brush =  brush)
            )
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(70.dp)
                .background(brush =  brush)
            )
        }

        Row(
            modifier = Modifier
                .padding(start = 40.dp, top = 5.dp)
        ) {
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(70.dp)
                .background(brush =  brush)
            )
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(70.dp)
                .background(brush =  brush)
            )
        }

        Spacer(modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .height(1.dp)
            .background(Gray500)
            .background(brush =  brush)
        )
        Row(
            modifier = Modifier
                .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(70.dp)
                .background(brush =  brush)
            )
            Spacer(modifier = Modifier
                .height(20.dp)
                .width(70.dp)
                .background(brush =  brush)
            )
        }
    }
}