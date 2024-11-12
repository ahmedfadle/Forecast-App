package com.dailyforecast.app.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Cities(
    val cities: List<City>?
):Parcelable