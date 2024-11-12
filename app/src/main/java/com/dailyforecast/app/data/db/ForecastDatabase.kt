package com.dailyforecast.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dailyforecast.app.data.entities.CityDB
import com.dailyforecast.app.data.entities.ForecastDB

@Database(
    entities = [CityDB::class,ForecastDB::class
    ],
    version =2,
    exportSchema = false
)
@TypeConverters(
    ForecastConverter::class
)
abstract class ForecastDatabase : RoomDatabase() {
    abstract fun forecastDao(): ForecastDao

}