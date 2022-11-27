package com.submission.submissionjetpackcompose.domain.usecase

import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.utils.base.LocalUseCase
import com.submission.submissionjetpackcompose.utils.mapper.toEntity
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class AddFavorite @Inject constructor(
    private val destinationRepository: DestinationRepository
) : LocalUseCase<AddFavorite.Params, Unit>(){

    data class Params(
        val entity: DestinationDomain
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        destinationRepository.saveFavorite(params.entity.toEntity())
        emit(Unit)
    }


}