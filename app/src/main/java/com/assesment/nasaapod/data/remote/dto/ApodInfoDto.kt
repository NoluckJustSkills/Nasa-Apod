package com.assesment.nasaapod.data.remote.dto


import com.assesment.nasaapod.data.local.entity.ApodInfoEntity
import com.assesment.nasaapod.domain.model.ApodInfo
import com.google.gson.annotations.SerializedName

data class ApodInfoDto(
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("hdurl")
    val hdurl: String,
    @SerializedName("media_type")
    val mediaType: String,
    @SerializedName("service_version")
    val serviceVersion: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
) {
    fun toApodInfoEntity() : ApodInfoEntity = ApodInfoEntity(
        date = date,
        explanation = explanation,
        mediaType = mediaType,
        title = title,
        url = url)
}