package com.submission.submissionjetpackcompose.domain.usecase

import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.utils.base.LocalUseCase
import com.submission.submissionjetpackcompose.utils.mapper.toEntity
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class AddFavoriteList @Inject constructor(
    private val destinationRepository: DestinationRepository
) : LocalUseCase<AddFavoriteList.Params, Unit>(){

    data class Params(
        val entityList: DestinationDomain
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        destinationRepository.saveFavoriteList(listOf(params.entityList.toEntity()))
        emit(Unit)
    }


}