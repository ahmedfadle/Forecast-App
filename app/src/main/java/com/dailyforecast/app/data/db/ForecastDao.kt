package com.dailyforecast.app.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dailyforecast.app.data.entities.CityDB
import com.dailyforecast.app.data.entities.ForecastDB
import com.dailyforecast.app.domain.models.City

@Dao
interface ForecastDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCities(vararg partnerCategories: CityDB)

    @Query("SELECT * FROM cities ")
    suspend fun getCities(): List<CityDB>

    @Query("DELETE FROM cities")
    suspend fun clearCities()




    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertForecastByCity(forecastDB: ForecastDB)


    @Query("SELECT * FROM forcast Where lat=:lat AND lon=:lon")
    suspend fun selectForecastByCity(lat:Double,lon:Double): ForecastDB

    @Query("DELETE FROM forcast Where lat=:lat AND lon=:lon")
    suspend fun clearForecastByCity(lat:Double,lon:Double)

}