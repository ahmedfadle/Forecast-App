package com.dailyforecast.app.domain.usecases

import com.dailyforecast.app.common.model.IResult
import com.dailyforecast.app.data.di.ForeCastRepositorynterator
import com.dailyforecast.app.domain.models.City
import com.dailyforecast.app.domain.repositories.ForeCastRepository
import javax.inject.Inject

class GetCitiesUseCaseImp  @Inject constructor(private val repository: ForeCastRepository):GetCitiesUseCase{
    override suspend operator fun invoke(): IResult<List<City>> {
        return repository.getCities()
    }

}