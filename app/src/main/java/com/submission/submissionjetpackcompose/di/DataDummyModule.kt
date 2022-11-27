package com.submission.submissionjetpackcompose.di

import com.submission.submissionjetpackcompose.data.model.DestinationEntity
import com.submission.submissionjetpackcompose.domain.model.DestinationDomain
import com.submission.submissionjetpackcompose.utils.datadummy.DataDummy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataDummyModule{

    @Singleton
    @Provides
    fun provideDataDummy(dataDummy: DataDummy): List<DestinationEntity> {
        return dataDummy.getData()
    }
}