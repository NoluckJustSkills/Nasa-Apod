package com.assesment.nasaapod.di

import android.app.Application
import androidx.room.Room
import com.assesment.nasaapod.data.local.ApodInfoDataBase
import com.assesment.nasaapod.data.remote.ApodApi
import com.assesment.nasaapod.data.repository.ApodInfoRepositoryImpl
import com.assesment.nasaapod.domain.repository.ApodInfoRepository
import com.assesment.nasaapod.domain.usecase.GetApodInfoUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApodInfoModule {

    @Provides
    @Singleton
    fun provideGetApodInfoUseCase(repository: ApodInfoRepository): GetApodInfoUsecase {
        return GetApodInfoUsecase(repository)
    }

    @Provides
    @Singleton
    fun provideApodInfoRepository(
        db: ApodInfoDataBase,
        api: ApodApi
    ):ApodInfoRepository {
        return ApodInfoRepositoryImpl(api,db.dao)
    }

    @Provides
    @Singleton
    fun provideApodInfoDatabase(app: Application) :ApodInfoDataBase {
        return Room.databaseBuilder(app,ApodInfoDataBase::class.java,
            "apod_db").build()
    }

    @Provides
    @Singleton
    fun provideApodApi(): ApodApi {
        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()
        return Retrofit.Builder()
            .baseUrl(ApodApi.BASE_URL.toHttpUrlOrNull()!!)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApodApi::class.java)
    }


}