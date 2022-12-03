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
import com.submission.submissionjetpackcompose.ui.theme.CafeColors
import com.submission.submissionjetpackcompose.ui.theme.Gray500
import com.submission.submissionjetpackcompose.ui.theme.White
import com.submission.submissionjetpackcompose.ui.theme.cardBackgroundColor

@Composable
fun ShimmerDetailItem(brush: Brush) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Column {
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
                            modifier = Modifier.padding(top= 10.dp)
                        )
                        Spacer(
                            modifier = Modifier
                                .height(20.dp)
                                .width(20.dp)
                                .background(brush = brush)
                        )


                        Spacer(
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                    }

                    Spacer(
                        modifier = Modifier.padding(top= 10.dp)
                    )
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(50.dp)
                            .background(brush = brush)
                    )
                    Spacer(
                        modifier = Modifier.padding(top= 10.dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(50.dp)
                            .background(brush = brush)
                    )
                    Spacer(
                        modifier = Modifier.padding(top= 10.dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(400.dp)
                            .background(brush = brush)
                    )
                    Spacer(
                        modifier = Modifier.padding(top= 10.dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(400.dp)
                            .background(brush = brush)
                    )
                    Spacer(
                        modifier = Modifier.padding(top= 10.dp)
                    )

                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(400.dp)
                            .background(brush = brush)
                    )
                }

            }


    }
}