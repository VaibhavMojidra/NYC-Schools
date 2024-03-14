package com.vaibhavmojidra.nycschools.data.api

import com.vaibhavmojidra.nycschools.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SchoolDataRetrofitInstance {
    companion object{
        fun getRetrofitInstance():Retrofit=Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }
}