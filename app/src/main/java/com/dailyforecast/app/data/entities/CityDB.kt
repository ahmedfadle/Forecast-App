package com.dailyforecast.app.data.entities

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dailyforecast.app.common.model.CachingConfigs
import com.dailyforecast.app.domain.models.City
import kotlinx.parcelize.Parcelize

@Entity(tableName = "cities")
@Parcelize
data class CityDB(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val city: City? = null
) : Parcelable


fun City.toCitytDB(
): CityDB {
    return CityDB(
        city = this,
    )
}

fun CityDB.toCity(
): City {
    return City(
        id = this.city?.id ?: 0,
        lat = this.city?.lat ?: 0.0,
        lon = this.city?.lon ?: 0.0,
        cityNameAr = this.city?.cityNameAr ?: "",
        cityNameEn = this.city?.cityNameEn ?: ""

    )
}
