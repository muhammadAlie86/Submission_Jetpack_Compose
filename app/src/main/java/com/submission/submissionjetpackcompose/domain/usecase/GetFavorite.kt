package com.submission.submissionjetpackcompose.domain.usecase

import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.utils.base.LocalUseCase
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetFavorite @Inject constructor(
    private val destinationRepository: DestinationRepository
) : LocalUseCase<GetFavorite.Params, DestinationDomain>(){

    data class Params(
        val destinationDomain: DestinationDomain
    )

    override suspend fun FlowCollector<DestinationDomain>.execute(params: Params) {
        val domainModel = params.destinationDomain.id
        destinationRepository.getFavorite(domainModel)
        emit(params.destinationDomain)
    }

}