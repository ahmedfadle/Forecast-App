package com.dailyforecast.app.data.di

import com.dailyforecast.app.data.repository.ForeCastRepositoryImp
import com.dailyforecast.app.data.repository.ForecastDataLocalSourceImp
import com.dailyforecast.app.data.repository.ForecastDataSource
import com.dailyforecast.app.data.repository.ForecastDataSourceImp
import com.dailyforecast.app.domain.repositories.ForeCastRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier

@Module
@InstallIn(ViewModelComponent::class)
interface ViewModelModule {

    @Binds
    @ForeCastRepositorynterator
    fun provideInLoginDataSource(inLoginDataSource: ForeCastRepositoryImp): ForeCastRepository

    @Binds
    @provideForecastDataSource
    fun provideForecastDataSource(inLoginDataSource: ForecastDataSourceImp): ForecastDataSource.Remote

    @Binds
    @com.dailyforecast.app.data.di.ForecastDataLocalSourceImp
    fun provideForecastDataLocalSourceImp(inLoginDataSource: ForecastDataLocalSourceImp): ForecastDataSource.Local


}
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ForeCastRepositorynterator

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class provideForecastDataSource

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ForecastDataLocalSourceImp

