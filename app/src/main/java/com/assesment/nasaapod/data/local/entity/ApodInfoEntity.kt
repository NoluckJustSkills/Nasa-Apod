package com.assesment.nasaapod.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.assesment.nasaapod.domain.model.ApodInfo
import com.google.gson.annotations.SerializedName

@Entity
data class ApodInfoEntity(val date: String,
                          val explanation: String,
                          val mediaType: String,
                          val title: String,
                          val url: String,
                          @PrimaryKey val id:Int? = null) {

    fun toApodInfo():ApodInfo = ApodInfo(
        date = date,
        explanation = explanation,
        mediaType = mediaType,
        title = title,
        url = url)
}
