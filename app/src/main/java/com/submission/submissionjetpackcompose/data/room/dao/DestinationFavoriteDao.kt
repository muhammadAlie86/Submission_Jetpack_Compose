package com.submission.submissionjetpackcompose.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.submission.submissionjetpackcompose.data.model.DestinationEntity
import com.submission.submissionjetpackcompose.utils.base.BaseDao
import com.submission.submissionjetpackcompose.utils.constanta.Constants.TABLE_NAME

@Dao
interface DestinationFavoriteDao : BaseDao<DestinationEntity>{
    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getFavoriteList(): List<DestinationEntity>

    @Query("SELECT * FROM $TABLE_NAME WHERE id =:favoriteId")
    suspend fun getFavorite(favoriteId: Int):DestinationEntity?

    @Query("DELETE FROM $TABLE_NAME WHERE id =:favoriteId")
    suspend fun deleteFavoriteById(favoriteId: Int)
}