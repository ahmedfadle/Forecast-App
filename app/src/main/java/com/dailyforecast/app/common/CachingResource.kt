package com.dailyforecast.app.common

import com.dailyforecast.app.common.model.CachingConfigs
import com.dailyforecast.app.common.model.DataSourseType
import com.dailyforecast.app.common.model.ErrorModel
import com.dailyforecast.app.common.model.IResult
import com.google.gson.Gson
import retrofit2.HttpException

interface CachingResource<T> {

    suspend fun load(): IResult<T> {
        return try {
                try {
                    val result = getFromRemote()
                    saveToLocal(result)
                    IResult.success(result, DataSourseType.REMOTE)
                } catch (ex: Exception) {
                    var localResult = getFromLocal()
                    if (localResult != null) {
                        IResult.success(localResult,DataSourseType.LOCAL)
                    }else{
                        if (ex is HttpException) {
                            try {
                                val errorBody = Gson().fromJson(
                                    ex.response()?.errorBody()?.string(),
                                    ErrorModel::class.java
                                )
                                IResult.failure(errorBody)
                            } catch (e: Exception) {
                                IResult.failure(ex.localizedMessage ?: "")
                            }

                        } else
                            IResult.failure(ex.localizedMessage?: "")
                }
            }

        } catch (e: Exception) {
            val errorBody = ErrorModel(
                error = e.localizedMessage,
                messageAr = e.localizedMessage,
                messageEn = e.localizedMessage,
                statusCode = null,
                statusNumber = null
            )
            IResult.failure(errorBody)
        }

    }

    suspend fun getFromRemote(): T

    suspend fun getFromLocal():  T?

    suspend fun saveToLocal(data: T)

}

