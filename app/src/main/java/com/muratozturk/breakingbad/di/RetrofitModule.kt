package com.muratozturk.breakingbad.di

import com.muratozturk.breakingbad.common.Constants.BASE_URL
import com.muratozturk.breakingbad.data.source.BreakingBadService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    @Singleton
    fun provideFoodService(): BreakingBadService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(BreakingBadService::class.java)

}