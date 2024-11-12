package com.dailyforecast.app.domain.repositories

import com.dailyforecast.app.common.model.IResult
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.models.ForecastModel

interface ForeCastRepository {
    suspend fun getCities(): IResult<List<City>>
    suspend fun forecast(lat: Double, lon: Double, appid: String): IResult<ForecastModel>
}