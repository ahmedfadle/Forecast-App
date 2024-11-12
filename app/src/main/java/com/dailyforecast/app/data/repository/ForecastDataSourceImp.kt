package com.dailyforecast.app.data.repository

import com.dailyforecast.app.data.api.ForecastApi
import com.dailyforecast.app.domain.models.Cities
import com.dailyforecast.app.domain.models.ForecastModel
import javax.inject.Inject

class ForecastDataSourceImp @Inject constructor(private val foreCastApi: ForecastApi) :
    ForecastDataSource.Remote {
    override suspend fun getCities(): Cities {
        return  foreCastApi.getCities()
    }

    override suspend fun forecast(lat: Double, lon: Double, appid: String): ForecastModel {
        return  foreCastApi.forecast(
            lat = lat,
            lon = lon,
            appid = appid
        )
    }


}