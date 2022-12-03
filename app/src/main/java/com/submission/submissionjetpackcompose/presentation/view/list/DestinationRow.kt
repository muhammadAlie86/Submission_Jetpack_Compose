package com.submission.submissionjetpackcompose.presentation.view.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.component.FavoriteButtonDestination
import com.submission.submissionjetpackcompose.presentation.component.RatingBar
import com.submission.submissionjetpackcompose.ui.theme.CafeTypography
import com.submission.submissionjetpackcompose.ui.theme.Gray500
import com.submission.submissionjetpackcompose.ui.theme.Red
import com.submission.submissionjetpackcompose.ui.theme.White
import com.submission.submissionjetpackcompose.utils.mapper.toEntity

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DestinationRow(
    viewModel: DestinationViewModel = hiltViewModel(),
    dto: DestinationDomain,
    onDetailClick: () -> Unit = {}
) {

    var isFavorite by rememberSaveable(dto) { mutableStateOf(dto.isFavorite) }
    Card(
        onClick = onDetailClick,
        modifier = Modifier
            .padding(10.dp)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(20.dp),
            )
            .clip(RoundedCornerShape(20.dp))
            .fillMaxWidth()
            .background(White)
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
                RatingBar(
                    modifier = Modifier
                        .padding(start = 10.dp),
                    rating = dto.rate)

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom,
                ) {
                    IconButton(onClick = {
                        isFavorite = !isFavorite
                        dto.isFavorite = isFavorite
                        viewModel.onTriggerEvent(DestinationEvent.AddOrRemoveFavorite(dto))
                    }) {
                        val tintColor = if (isFavorite) Red else Gray500
                        Icon(
                            painter = rememberVectorPainter(Icons.Default.Favorite),
                            contentDescription = null,
                            tint = tintColor
                        )
                    }
                }
            }
        }

    }
}
