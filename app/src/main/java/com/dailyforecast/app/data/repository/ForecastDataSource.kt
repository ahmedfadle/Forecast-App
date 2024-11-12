package com.dailyforecast.app.data.repository

import com.dailyforecast.app.common.model.CachingConfigs
import com.dailyforecast.app.domain.models.Cities
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.models.ForecastModel

interface ForecastDataSource {



    interface Remote {
        suspend fun getCities(
        ): Cities

        suspend fun forecast(lat: Double, lon: Double, appid: String): ForecastModel

    }

    interface Local {
         suspend fun getCities(): List<City>
        suspend fun cacheCities(cities:List<City>)
        suspend fun forecast(lat:Double,lon:Double) : ForecastModel?
        suspend fun cacheForecast(forecastModel:ForecastModel)

    }

}