package com.dailyforecast.app.data.di

import com.dailyforecast.app.data.repository.ForeCastRepositoryImp
import com.dailyforecast.app.data.repository.ForecastDataSource
import com.dailyforecast.app.domain.repositories.ForeCastRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(
          localDataSource: ForecastDataSource.Local,
          remoteDataSource: ForecastDataSource.Remote
    ): ForeCastRepository {
        return ForeCastRepositoryImp(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )
    }
}