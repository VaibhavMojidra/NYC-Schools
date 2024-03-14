package com.vaibhavmojidra.nycschools.di

import com.vaibhavmojidra.nycschools.data.api.SchoolDataAPIService
import com.vaibhavmojidra.nycschools.data.repository.SchoolRepositoryImpl
import com.vaibhavmojidra.nycschools.domain.repository.SchoolRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//Module to provide instance of SchoolRepository Interface
@Module
@InstallIn(SingletonComponent::class)
object SchoolModule {

    @Singleton
    @Provides
    fun getSchoolRepository(schoolDataAPIService: SchoolDataAPIService):SchoolRepository=SchoolRepositoryImpl(schoolDataAPIService)


}