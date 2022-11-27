package com.submission.submissionjetpackcompose.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.submission.submissionjetpackcompose.utils.constanta.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class DestinationEntity(

    @PrimaryKey
    var id : Int = 0,
    var name : String = "",
    var rate : Float = 0F,
    var location : String = "",
    var description : String = "",
    var image : Int = 0,
    var isFavorite : Boolean= false
)