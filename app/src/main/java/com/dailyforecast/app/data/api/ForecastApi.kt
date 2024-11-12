package com.dailyforecast.app.data.api

import com.dailyforecast.app.domain.models.Cities
import com.dailyforecast.app.domain.models.ForecastModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {
    @GET("/data/2.5/forecast")
    suspend fun forecast(@Query("lat") lat: Double,@Query("lon") lon: Double,@Query("appid") appid: String): ForecastModel


    @GET("/uploads/cities.json")
    suspend fun getCities(): Cities



}