package com.muratozturk.breakingbad.di

import com.muratozturk.breakingbad.data.source.BreakingBadService
import com.muratozturk.breakingbad.data.source.RemoteDataSourceImpl
import com.muratozturk.breakingbad.domain.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource(foodService: BreakingBadService): RemoteDataSource =
        RemoteDataSourceImpl(foodService)
}