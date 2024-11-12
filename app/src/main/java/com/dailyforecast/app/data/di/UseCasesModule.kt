package com.dailyforecast.app.data.di

import com.dailyforecast.app.data.repository.ForeCastRepositoryImp
import com.dailyforecast.app.domain.repositories.ForeCastRepository
import com.dailyforecast.app.domain.usecases.GetCitiesUseCase
import com.dailyforecast.app.domain.usecases.GetCitiesUseCaseImp
import com.dailyforecast.app.domain.usecases.GetForeCastUseCaseImp
import com.dailyforecast.app.domain.usecases.GetForecastUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class UseCasesModule {

    @Provides
    @ViewModelScoped
    fun provideGetCitiesUseCase(repository: ForeCastRepositoryImp): GetCitiesUseCase {
        return GetCitiesUseCaseImp(repository)
    }
    @Provides
    @ViewModelScoped
    fun provideGetForecastUseCase(repository: ForeCastRepositoryImp): GetForecastUseCase {
        return GetForeCastUseCaseImp(repository)
    }
}