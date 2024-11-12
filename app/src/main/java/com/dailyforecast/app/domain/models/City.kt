package com.dailyforecast.app.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val cityNameAr: String?,
    val cityNameEn: String?,
    val id: Int?,
    val lat: Double?,
    val lon: Double?
) :Parcelable