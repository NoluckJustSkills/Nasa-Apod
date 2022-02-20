package com.assesment.nasaapod.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.assesment.nasaapod.data.local.entity.ApodInfoEntity

@Database(
    entities = [ApodInfoEntity::class],
    version = 1
)
abstract class ApodInfoDataBase: RoomDatabase() {

    abstract val dao: ApodInfoDao
}