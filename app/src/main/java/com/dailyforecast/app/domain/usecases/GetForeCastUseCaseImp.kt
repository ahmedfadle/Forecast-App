package com.dailyforecast.app.domain.usecases

import com.dailyforecast.app.common.model.IResult
import com.dailyforecast.app.data.di.ForeCastRepositorynterator
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.models.ForecastModel
import com.dailyforecast.app.domain.repositories.ForeCastRepository
import javax.inject.Inject

class GetForeCastUseCaseImp  @Inject constructor(private val repository: ForeCastRepository):GetForecastUseCase{
    override suspend operator fun invoke(lat: Double, lon: Double, appid: String): IResult<ForecastModel>{
        return repository.forecast(lat, lon, appid)
    }

}