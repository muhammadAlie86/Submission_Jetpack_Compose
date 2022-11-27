package com.submission.submissionjetpackcompose.di

import com.submission.submissionjetpackcompose.data.repository.DestinationRepository
import com.submission.submissionjetpackcompose.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    @Singleton
    @Provides
    fun provideDeleteFavoriteByIdUseCase(repository: DestinationRepository): DeleteFavoriteById {
        return DeleteFavoriteById(repository)
    }

    @Singleton
    @Provides
    fun provideGetFavoriteUseCase(repository: DestinationRepository): GetFavorite {
        return GetFavorite(repository)
    }

    @Singleton
    @Provides
    fun provideGetFavoriteListUseCase(repository: DestinationRepository): GetFavoriteList {
        return GetFavoriteList(repository)
    }

    @Singleton
    @Provides
    fun provideAddFavoriteUseCase(repository: DestinationRepository): AddFavorite {
        return AddFavorite(repository)
    }

    @Singleton
    @Provides
    fun provideAddFavoriteListUseCase(repository: DestinationRepository): AddFavoriteList {
        return AddFavoriteList(repository)
    }

}