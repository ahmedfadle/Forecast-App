package com.dailyforecast.app.data.repository

import com.dailyforecast.app.common.CachingResource
import com.dailyforecast.app.common.model.IResult
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.models.ForecastModel
import com.dailyforecast.app.domain.repositories.ForeCastRepository
import javax.inject.Inject

class ForeCastRepositoryImp @Inject constructor(
    private val localDataSource: ForecastDataSource.Local,
    private val remoteDataSource: ForecastDataSource.Remote
) : ForeCastRepository {


    override suspend fun getCities(): IResult<List<City>> {
        return object : CachingResource<List<City>> {
            override suspend fun getFromRemote(): List<City> {
                return remoteDataSource.getCities().cities ?: emptyList()
            }

            override suspend fun getFromLocal():  List<City> {
                return localDataSource.getCities()
            }

            override suspend fun saveToLocal(data: List<City>) {
                localDataSource.cacheCities(cities = data)
            }
        }.load()

    }
        override suspend fun forecast(lat: Double, lon: Double, appid: String): IResult<ForecastModel> {
            return object : CachingResource<ForecastModel> {
                override suspend fun getFromRemote(): ForecastModel {
                    return remoteDataSource.forecast(lat = lat, lon = lon, appid = appid)

                }

                override suspend fun getFromLocal(): ForecastModel? {
                    return localDataSource.forecast(lat = lat, lon = lon)
                }

                override suspend fun saveToLocal(data: ForecastModel) {
                    localDataSource.cacheForecast(forecastModel = data)
                }
            }.load()

        }
    }