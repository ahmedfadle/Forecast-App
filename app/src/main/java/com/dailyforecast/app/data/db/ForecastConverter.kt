package com.dailyforecast.app.data.db

import androidx.room.TypeConverter
import com.dailyforecast.app.common.model.CachingConfigs
import com.dailyforecast.app.data.entities.CityDB
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.models.ForecastModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ForecastConverter {
    var gson = Gson()

    @TypeConverter
    fun fromCityToString(place: City) :String?{
        return gson.toJson(place)
    }

    @TypeConverter
    fun fromStringToCity(data:String?): City?{
        val type = object :TypeToken<City?>() {}.type
        return gson.fromJson(data,type)
    }

    @TypeConverter
    fun fromForecastModelToString(place: ForecastModel) :String?{
        return gson.toJson(place)
    }

    @TypeConverter
    fun fromStringTForecastModel(data:String?): ForecastModel?{
        val type = object :TypeToken<ForecastModel?>() {}.type
        return gson.fromJson(data,type)
    }


    @TypeConverter
    fun fromConfigToString(cachingConfigs: CachingConfigs): String? {
        return gson.toJson(cachingConfigs)
    }

    // single model
    @TypeConverter
    fun fromStringToConfig(data: String?): CachingConfigs? {
        val type = object : TypeToken<CachingConfigs?>() {}.type
        return gson.fromJson(data, type)
    }
}