package com.submission.submissionjetpackcompose.di

import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.utils.datadummy.DestinationData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {



    @Singleton
    @Provides
    fun provideDataDummyRepository(destinationData: DestinationData): DataDummyRepository {
        return DataDummyRepository(destinationData)
    }
}