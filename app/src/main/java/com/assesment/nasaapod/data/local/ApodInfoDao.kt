package com.assesment.nasaapod.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.assesment.nasaapod.data.local.entity.ApodInfoEntity
import com.assesment.nasaapod.domain.model.ApodInfo

@Dao
interface ApodInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApodInfo(apodInfo: ApodInfoEntity)

    @Query("SELECT * FROM ApodInfoEntity")
    suspend fun getFavouriteApodInfo():List<ApodInfoEntity>

    @Query("SELECT * FROM ApodInfoEntity")
    suspend fun getApodInfo():ApodInfoEntity
}