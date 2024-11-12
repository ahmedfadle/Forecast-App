package com.dailyforecast.app.data.entities

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dailyforecast.app.common.model.CachingConfigs
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.models.ForecastModel
import kotlinx.parcelize.Parcelize

@Entity(tableName = "forcast")
@Parcelize
data class ForecastDB(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val forecast: ForecastModel? = null,
    val lat: Double? = null,
    val lon: Double? =null,

) : Parcelable


fun ForecastModel.toForecastModeltDB(
     lat: Double? = null,
     lon: Double? =null,
): ForecastDB {
    return ForecastDB(
        lat = lat,
        lon = lon,
        forecast = this)
}

fun ForecastDB.toForecast(
): ForecastModel {
    return ForecastModel(
       city = this.forecast?.city,
        list = this.forecast?.list,
        cnt = this.forecast?.cnt,
        cod = this.forecast?.cod,
        message = this.forecast?.message

    )
}
