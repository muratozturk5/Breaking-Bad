package com.muratozturk.breakingbad.di

import android.app.Application
import com.muratozturk.breakingbad.data.repository.BreakingBadRepositoryImpl
import com.muratozturk.breakingbad.data.source.RemoteDataSourceImpl
import com.muratozturk.breakingbad.domain.repository.BreakingBadRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesFoodRepository(remoteDataSource: RemoteDataSourceImpl): BreakingBadRepository = BreakingBadRepositoryImpl(remoteDataSource)
}