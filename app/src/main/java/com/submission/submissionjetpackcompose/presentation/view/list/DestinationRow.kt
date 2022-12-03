package com.submission.submissionjetpackcompose.presentation.view.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.presentation.component.FavoriteButtonDestination
import com.submission.submissionjetpackcompose.ui.theme.CafeTypography
import com.submission.submissionjetpackcompose.ui.theme.White
import com.submission.submissionjetpackcompose.utils.mapper.toEntity

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DestinationRow(
    viewModel: DestinationViewModel = hiltViewModel(),
    dto: DestinationDomain,
    onDetailClick: () -> Unit = {}
) {
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
                Text(
                    text = dto.rate.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 2.dp, start = 16.dp),
                    style = CafeTypography.subtitle1
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom,
                ) {
                    FavoriteButtonDestination(viewModel, dto)
                }
            }
        }

    }
}
