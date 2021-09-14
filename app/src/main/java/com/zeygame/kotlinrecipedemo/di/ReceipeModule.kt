package com.zeygame.kotlinrecipedemo.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.zeygame.kotlinrecipedemo.service.ApiService
import com.zeygame.kotlinrecipedemo.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ReceipeModule {
    @Provides
    @Singleton
    fun provideRetrofitInstance():ApiService {
        val gson =  GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService::class.java)
    }
}