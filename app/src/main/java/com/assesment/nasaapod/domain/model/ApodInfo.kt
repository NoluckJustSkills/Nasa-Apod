package com.assesment.nasaapod.domain.model

import com.google.gson.annotations.SerializedName

data class ApodInfo(@SerializedName("date")
                     val date: String,
                     @SerializedName("explanation")
                     val explanation: String,
                     @SerializedName("media_type")
                     val mediaType: String,
                     @SerializedName("title")
                     val title: String,
                     @SerializedName("url")
                     val url: String)
