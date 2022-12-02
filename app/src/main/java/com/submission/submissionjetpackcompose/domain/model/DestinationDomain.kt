package com.submission.submissionjetpackcompose.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DestinationDomain (

    var id : Int = 0,
    var name : String = "",
    var rate : Float = 0F,
    var location : String = "",
    var description : String = "",
    var image : Int = 0,
    var isFavorite : Boolean= false,
    val destinationList: MutableList<DestinationDomain> = mutableListOf(),
    ) : Parcelable