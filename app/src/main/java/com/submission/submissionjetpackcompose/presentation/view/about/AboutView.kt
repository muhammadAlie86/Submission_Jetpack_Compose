package com.submission.submissionjetpackcompose.presentation.view.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.submission.submissionjetpackcompose.data.model.Profile
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.component.FavoriteButton
import com.submission.submissionjetpackcompose.presentation.component.FavoriteButtonDetail
import com.submission.submissionjetpackcompose.ui.theme.*
import com.submission.submissionjetpackcompose.utils.nav.NavigationProvider

@Composable
fun AboutView(viewModel: AboutViewModel,data : Profile, navigator: NavigationProvider? = null) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(CafeColors.cardBackgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
        ) {
            Column {
                Image(
                    painter = painterResource(data.imgProfile),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(size = 18.dp))
                )
                Text(
                    text = data.name,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = CafeTypography.h5
                )

                Text(
                    text = data.email,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = CafeTypography.h5
                )
                Text(
                    text = data.phone,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = CafeTypography.h5
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
                color = CafeColors.dividerColor
            )
        }
    }
}