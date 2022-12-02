package com.submission.submissionjetpackcompose.domain.usecase

import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.utils.base.LocalUseCase
import com.submission.submissionjetpackcompose.utils.mapper.toDomain
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetDetailDestination @Inject constructor(
    private val dataDummyRepository : DataDummyRepository
) : LocalUseCase<GetDetailDestination.Params, DestinationDomain>(){

    data class Params(
        val detailId : Int
    )

    override suspend fun FlowCollector<DestinationDomain>.execute(params: Params) {
        val domainModelID = params.detailId
        val result = dataDummyRepository.getDetailDestination(domainModelID)
        emit(result.toDomain())
    }


}