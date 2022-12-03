package com.submission.submissionjetpackcompose.presentation.view.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.submission.submissionjetpackcompose.data.model.Profile
import com.submission.submissionjetpackcompose.ui.theme.DestinationTypography
import com.submission.submissionjetpackcompose.ui.theme.dividerColor
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider

@Composable
fun AboutView(viewModel: AboutViewModel,data : Profile, navigator: NavigationProvider? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
        ) {
            Image(
                painter = painterResource(data.imgProfile),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clip(CircleShape)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    modifier = Modifier.weight(1f),
                    text = "Nama :",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = DestinationTypography.subtitle1
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = data.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = DestinationTypography.subtitle1
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    modifier = Modifier.weight(1f),
                    text = "Email :",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = DestinationTypography.subtitle1
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = data.email,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = DestinationTypography.subtitle1
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Text(
                    modifier = Modifier.weight(1f),
                    text = "No Telepon :",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = DestinationTypography.subtitle1
                )

                Text(
                    modifier = Modifier.weight(1f),
                    text = data.phone,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = DestinationTypography.subtitle1
                )
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
                color = Color.DarkGray
            )
        }
    }
}