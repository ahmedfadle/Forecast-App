package com.dailyforecast.app.data.di

import com.dailyforecast.app.data.db.ForecastDao
import com.dailyforecast.app.data.db.ForecastDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CachingModule {


    @Provides
    fun provideMovieDao(forcastDatabase: ForecastDatabase): ForecastDao {
        return forcastDatabase.forecastDao()
    }

}