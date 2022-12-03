package com.submission.submissionjetpackcompose.presentation.component

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.math.*


@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Float = 0.0F,
    stars: Int = 5,
    starsColor: Color = Color.Yellow,
) {

    val filledStars = floor(rating)
    val unfilledStars = (stars - ceil(rating))
    val halfStar = !(rating.rem(1).equals(0.0))

    Row(modifier = modifier) {
        repeat(filledStars.toInt()) {
            Icon(imageVector = Icons.Outlined.Star, contentDescription = null, tint = starsColor)
        }

        if (halfStar) {
            Icon(
                imageVector = Icons.Outlined.StarHalf,
                contentDescription = null,
                tint = starsColor
            )
        }

        repeat(unfilledStars.toInt()) {
            Icon(
                imageVector = Icons.Outlined.StarOutline,
                contentDescription = null,
                tint = starsColor
            )
        }
    }
}