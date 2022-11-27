package com.submission.submissionjetpackcompose.domain.usecase

import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.utils.base.LocalUseCase
import com.submission.submissionjetpackcompose.utils.mapper.toDestinationDomainList
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetFavoriteList @Inject constructor(
    private val destinationRepository: DestinationRepository
) : LocalUseCase<Unit, List<DestinationDomain>>(){

    override suspend fun FlowCollector<List<DestinationDomain>>.execute(params: Unit) {
        val domainModel = destinationRepository.getFavoriteList()
        emit(domainModel.toDestinationDomainList())
    }


}