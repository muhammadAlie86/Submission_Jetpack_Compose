package com.submission.submissionjetpackcompose.di

import android.content.Context
import androidx.room.Room
import com.submission.submissionjetpackcompose.data.room.dao.DestinationFavoriteDao
import com.submission.submissionjetpackcompose.data.room.db.DestinationDatabase
import com.submission.submissionjetpackcompose.utils.constanta.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    @Named(value = DB_NAME)
    fun provideDatabaseName(): String {
        return DB_NAME
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @Named(value = DB_NAME) dbname: String,
        @ApplicationContext context: Context
    ): DestinationDatabase {
        return Room.databaseBuilder(context, DestinationDatabase::class.java, dbname)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideCharacterFavoriteDao(appDatabase: DestinationDatabase): DestinationFavoriteDao {
        return appDatabase.destinationFavoriteDao()
    }


}