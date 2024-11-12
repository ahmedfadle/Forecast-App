package com.dailyforecast.app.common.di

import android.content.Context
import androidx.room.Room
import com.dailyforecast.app.data.db.ForecastDao
import com.dailyforecast.app.data.db.ForecastDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = synchronized(ForecastDatabase::class.java) {
        Room.databaseBuilder(
            context,
            ForecastDatabase::class.java,
            "ForecastDatabase"
        ) .fallbackToDestructiveMigration()
            .build()
    }



}