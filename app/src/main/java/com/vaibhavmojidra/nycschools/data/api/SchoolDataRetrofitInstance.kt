package com.vaibhavmojidra.nycschools.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SchoolDataRetrofitInstance {
    companion object{
        val BASE_URL="https://data.cityofnewyork.us"
        fun getRetrofitInstance():Retrofit=Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
}