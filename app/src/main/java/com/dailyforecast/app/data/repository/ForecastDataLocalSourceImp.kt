package com.dailyforecast.app.data.repository

import com.dailyforecast.app.common.model.CachingConfigs
import com.dailyforecast.app.data.db.ForecastDao
import com.dailyforecast.app.data.entities.toCity
import com.dailyforecast.app.data.entities.toCitytDB
import com.dailyforecast.app.data.entities.toForecast
import com.dailyforecast.app.data.entities.toForecastModeltDB
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.models.ForecastModel
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

class ForecastDataLocalSourceImp @Inject constructor(private val forecastDao: ForecastDao) :
    ForecastDataSource.Local {

    private val mutex = Mutex()

    override suspend fun getCities():  List<City> {
        val cities = forecastDao.getCities()
        return  cities.map { x -> x.toCity() }

    }

    override suspend fun cacheCities(cities: List<City>) {
        mutex.withLock { //this is equivalent to Synchronize in Java to make sure that clear and insert are executed on the same thread
            forecastDao.clearCities()
            forecastDao.insertCities(*cities.map {
                it.toCitytDB()
            }.toTypedArray())
        }
    }


    override suspend fun forecast(lat: Double, lon: Double):  ForecastModel?{
        val forecas = forecastDao.selectForecastByCity(lat = lat, lon = lon)
        return forecas.toForecast()

    }

    override suspend fun cacheForecast(
        forecastModel: ForecastModel,
    ) {
        mutex.withLock { //this is equivalent to Synchronize in Java to make sure that clear and insert are executed on the same thread
            forecastDao.clearForecastByCity(
                forecastModel.city?.coord?.lat ?: 0.0,
                forecastModel.city?.coord?.lat ?: 0.0
            )
            forecastDao.insertForecastByCity(
                forecastModel.toForecastModeltDB(
                    lat = forecastModel.city?.coord?.lat, lon = forecastModel.city?.coord?.lon
                )
            )
        }
    }


}