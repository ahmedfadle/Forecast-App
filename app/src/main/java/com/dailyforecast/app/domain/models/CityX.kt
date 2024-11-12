package com.dailyforecast.app.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CityX(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
):Parcelable