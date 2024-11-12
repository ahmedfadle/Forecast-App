package com.dailyforecast.app.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForecastModel(
    val city: CityX?,
    val cnt: Int?,
    val cod: String?,
    val list: List<ForecastItem>?,
    val message: Int?
):Parcelable