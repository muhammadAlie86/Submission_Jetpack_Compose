package com.submission.submissionjetpackcompose.data.repository

import com.submission.submissionjetpackcompose.data.model.DestinationEntity
import com.submission.submissionjetpackcompose.data.room.dao.DestinationFavoriteDao
import javax.inject.Inject

class DestinationRepository @Inject constructor(
    private val dao : DestinationFavoriteDao
) {
    suspend fun getFavoriteList() = dao.getFavoriteList()

    suspend fun getFavorite(favoriteId: Int) = dao.getFavorite(favoriteId)

    suspend fun deleteFavoriteById(favoriteId: Int) = dao.deleteFavoriteById(favoriteId)

    suspend fun saveFavorite(entity: DestinationEntity) = dao.insert(entity)

    suspend fun saveFavoriteList(entityList: List<DestinationEntity>) = dao.insert(entityList)
}