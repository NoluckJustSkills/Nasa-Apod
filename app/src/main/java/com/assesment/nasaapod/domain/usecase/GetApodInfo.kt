package com.assesment.nasaapod.domain.usecase

import com.assesment.nasaapod.core.util.Resource
import com.assesment.nasaapod.domain.model.ApodInfo
import com.assesment.nasaapod.domain.repository.ApodInfoRepository
import kotlinx.coroutines.flow.Flow

class GetApodInfo(
    private val repository: ApodInfoRepository
) {

    operator fun invoke(): Flow<Resource<ApodInfo>> {
        return repository.getApodInfo()
    }

}