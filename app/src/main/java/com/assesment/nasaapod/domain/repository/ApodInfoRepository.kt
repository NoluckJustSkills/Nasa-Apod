package com.assesment.nasaapod.domain.repository

import com.assesment.nasaapod.core.util.Resource
import com.assesment.nasaapod.domain.model.ApodInfo
import kotlinx.coroutines.flow.Flow

interface ApodInfoRepository {

    fun getApodInfo(): Flow<Resource<ApodInfo>>
}