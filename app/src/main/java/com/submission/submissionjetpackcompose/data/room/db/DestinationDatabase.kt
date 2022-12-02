package com.submission.submissionjetpackcompose.data.room.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.submission.submissionjetpackcompose.data.model.DestinationEntity
import com.submission.submissionjetpackcompose.data.room.dao.DestinationFavoriteDao

@Database(
    entities = [DestinationEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DestinationDatabase : RoomDatabase() {
    abstract fun destinationFavoriteDao(): DestinationFavoriteDao
}