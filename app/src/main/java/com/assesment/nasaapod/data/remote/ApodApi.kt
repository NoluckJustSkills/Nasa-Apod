package com.assesment.nasaapod.data.remote

import com.assesment.nasaapod.data.remote.dto.ApodInfoDto
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApodApi {

    @GET("apod")
    suspend fun getTodayContent(@Query("api_key") apiKey: String = "YDEnvxsqn7a0X7YslkIUFBCV7jINi6SqjdAJlyv4"): Response<ApodInfoDto>

    companion object {
        val BASE_URL = "https://api.nasa.gov/planetary/"

    }
}