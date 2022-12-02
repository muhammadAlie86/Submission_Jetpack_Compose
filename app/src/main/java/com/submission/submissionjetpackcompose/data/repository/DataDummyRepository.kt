package com.submission.submissionjetpackcompose.data.repository

import com.submission.submissionjetpackcompose.utils.datadummy.DestinationData
import javax.inject.Inject

class DataDummyRepository @Inject constructor(
    private val destinationData: DestinationData
) {

    fun getDestinationList() = destinationData.generateDummyData()

    fun getDetailDestination(detailId: Int) = destinationData.generateDummyData()[detailId]

    fun getProfile() = destinationData.generateAboutData()

}