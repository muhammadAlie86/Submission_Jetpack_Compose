package com.submission.submissionjetpackcompose.presentation.view.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.component.FavoriteButton
import com.submission.submissionjetpackcompose.presentation.component.FavoriteButtonDestination
import com.submission.submissionjetpackcompose.ui.theme.CafeTypography
import com.submission.submissionjetpackcompose.ui.theme.RedDark
import com.submission.submissionjetpackcompose.utils.mapper.toEntity

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FavoriteRow(
    modifier: Modifier = Modifier,
    dto: DestinationDomain,
    onDetailClick: () -> Unit = {},
    onDeleteClick: () -> Unit = {}
) {
    Card(
        onClick = onDetailClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(
                vertical = 4.dp,
                horizontal = 8.dp
            ),
        elevation = 8.dp
    ) {
        Row {
            Image(
                painter = painterResource(dto.image),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .height(100.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(size = 18.dp))
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 12.dp, start = 8.dp, bottom = 4.dp)
            ) {
                Text(
                    text = dto.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp, start = 16.dp),
                    style = CafeTypography.body1
                )
                Text(
                    text = dto.rate.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp, start = 16.dp),
                    style = CafeTypography.subtitle1
                )
            }
            IconButton(
                onClick = onDeleteClick,
                modifier = modifier
                    .width(34.dp)
                    .height(34.dp)
            ) {
                Icon(
                    painter = rememberVectorPainter(Icons.Default.Delete),
                    contentDescription = null,
                    tint = RedDark
                )
            }
        }

    }
}
