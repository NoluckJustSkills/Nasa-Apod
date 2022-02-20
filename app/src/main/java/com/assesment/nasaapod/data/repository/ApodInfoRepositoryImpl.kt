package com.assesment.nasaapod.data.repository

import com.assesment.nasaapod.core.util.Resource
import com.assesment.nasaapod.data.local.ApodInfoDao
import com.assesment.nasaapod.data.remote.ApodApi
import com.assesment.nasaapod.domain.model.ApodInfo
import com.assesment.nasaapod.domain.repository.ApodInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ApodInfoRepositoryImpl(
    private val api: ApodApi,
    private val dao: ApodInfoDao
): ApodInfoRepository {

    override fun getApodInfo(): Flow<Resource<ApodInfo>> = flow {

        emit(Resource.Loading())
        val apodInfo = dao.getApodInfo().toApodInfo()
        emit(Resource.Loading(data = apodInfo))

        try{
            val remoteApodInfo = api.getTodayContent()
            remoteApodInfo.body()?.let { dao.insertApodInfo(it.toApodInfoEntity()) }
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Something went wrong,Check internet connection",
                data = apodInfo))
        }catch (e: IOException) {
            emit(Resource.Error(
                message = "Could'nt reach server,Check internet connection",
                data = apodInfo))
        }

        val newApodData = dao.getApodInfo().toApodInfo()
        emit(Resource.Success(newApodData))

    }

}