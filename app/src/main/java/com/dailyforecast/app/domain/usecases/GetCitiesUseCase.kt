package com.dailyforecast.app.domain.usecases

import com.dailyforecast.app.common.model.IResult
import com.dailyforecast.app.domain.models.City

interface GetCitiesUseCase {

    suspend fun invoke(): IResult<List<City>>


}