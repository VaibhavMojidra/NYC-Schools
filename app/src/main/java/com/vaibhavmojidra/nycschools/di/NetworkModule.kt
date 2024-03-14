package com.vaibhavmojidra.nycschools.di

import com.vaibhavmojidra.nycschools.BuildConfig
import com.vaibhavmojidra.nycschools.data.api.SchoolDataAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


//Module to provide instance of SchoolDataAPIService
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesSchoolDataAPIService():SchoolDataAPIService= Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .build().create(SchoolDataAPIService::class.java)
}