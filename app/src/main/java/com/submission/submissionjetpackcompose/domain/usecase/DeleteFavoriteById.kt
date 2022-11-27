package com.submission.submissionjetpackcompose.domain.usecase

import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.utils.base.LocalUseCase
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class DeleteFavoriteById @Inject constructor(
    private val destinationRepository: DestinationRepository
) : LocalUseCase<DeleteFavoriteById.Params,Unit>(){

    data class Params(
        val destinationDomain: DestinationDomain
    )

    override suspend fun FlowCollector<Unit>.execute(params: Params) {
        val domainModel = params.destinationDomain.id
        destinationRepository.deleteFavoriteById(domainModel)
        emit(Unit)
    }


}