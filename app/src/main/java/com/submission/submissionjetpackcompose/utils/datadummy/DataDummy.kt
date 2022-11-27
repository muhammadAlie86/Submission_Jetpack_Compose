package com.submission.submissionjetpackcompose.utils.datadummy

import javax.inject.Inject

class DataDummy @Inject constructor(
    private val data: DestinationData
) {

    fun getData() = data.generateDummyData()
}