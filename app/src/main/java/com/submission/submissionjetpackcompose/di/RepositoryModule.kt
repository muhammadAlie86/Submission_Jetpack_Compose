package com.submission.submissionjetpackcompose.di

import com.submission.submissionjetpackcompose.data.repository.DataDummyRepository
import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.data.room.dao.DestinationFavoriteDao
import com.submission.submissionjetpackcompose.utils.datadummy.DataDummy
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
    fun provideDestinationRepository(dao: DestinationFavoriteDao): DestinationRepository {
        return DestinationRepository(dao)
    }

    @Singleton
    @Provides
    fun provideDataDummyRepository(destinationData: DestinationData): DataDummyRepository {
        return DataDummyRepository(destinationData)
    }
}