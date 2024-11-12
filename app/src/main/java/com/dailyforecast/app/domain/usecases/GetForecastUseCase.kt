package com.dailyforecast.app.domain.usecases

import com.dailyforecast.app.common.model.IResult
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.models.ForecastModel

interface GetForecastUseCase {

    suspend fun invoke(lat: Double, lon: Double, appid: String):IResult<ForecastModel>


}