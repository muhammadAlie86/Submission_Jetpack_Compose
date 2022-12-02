package com.submission.submissionjetpackcompose.domain.usecase

import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.utils.base.LocalUseCase
import com.submission.submissionjetpackcompose.utils.datadummy.DataDummy
import com.submission.submissionjetpackcompose.utils.mapper.toDestinationDomainList
import com.submission.submissionjetpackcompose.utils.mapper.toDomain
import com.submission.submissionjetpackcompose.utils.mvi.BaseViewState
import kotlinx.coroutines.flow.FlowCollector
import javax.inject.Inject

class GetDestinationList @Inject constructor(
    private val dataDummyRepository : DataDummyRepository
) : LocalUseCase<Unit, List<DestinationDomain>>(){

    override suspend fun FlowCollector<List<DestinationDomain>>.execute(params: Unit) {
        val result = dataDummyRepository.getDestinationList()
        emit(result.map {
            it.toDomain()
        })
    }

}