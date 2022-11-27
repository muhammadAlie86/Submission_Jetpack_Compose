package com.submission.submissionjetpackcompose.di

import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.data.room.dao.DestinationFavoriteDao
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
    fun provideCafeRepository(dao: DestinationFavoriteDao): DestinationRepository {
        return DestinationRepository(dao)
    }
}