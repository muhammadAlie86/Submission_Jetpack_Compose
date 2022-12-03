package com.submission.submissionjetpackcompose.presentation.view.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.component.RatingBar
import com.submission.submissionjetpackcompose.ui.theme.*
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider

@Composable
fun DetailDestinationView(viewModel: DetailViewModel,dto : DestinationDomain, navigator: NavigationProvider? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(DestinationColors.cardBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column {
                    Image(
                        painter = painterResource(dto.image),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(size = 18.dp))
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        //CharacterStatusView(dto)
                        Text(
                            text = dto.name,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            style = DestinationTypography.h5
                        )
                    }
                    RatingBar( rating = dto.rate)
                    Text(
                        text = dto.location,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = DestinationTypography.h6
                    )
                    Text(text = dto.description, style = DestinationTypography.subtitle1)
                }

            }
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
            )

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp),
                color = DestinationColors.dividerColor
            )
        }
    }
}