package com.dailyforecast.app.data.di

import com.dailyforecast.app.data.api.ForecastApi
import com.dailyforecast.app.data.db.ForecastDao
import com.dailyforecast.app.data.repository.ForecastDataLocalSourceImp
import com.dailyforecast.app.data.repository.ForecastDataSource
import com.dailyforecast.app.data.repository.ForecastDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun provideForecastDataSourceRemoteDataSource(api: ForecastApi): ForecastDataSource.Remote {
        return ForecastDataSourceImp(api)
    }

    @Provides
    fun provideForecastDataSourceLocalDataSource(dao: ForecastDao): ForecastDataSource.Local {
        return ForecastDataLocalSourceImp(dao)
    }

}