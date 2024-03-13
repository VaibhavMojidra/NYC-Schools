package com.vaibhavmojidra.nycschools.data.api

import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.data.model.SchoolSatScoreList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SchoolDataService {
    @GET("/resource/s3k6-pzi2.json")
    suspend fun getSchoolList():Response<SchoolList>

    @GET("/resource/f9bf-2cp4.json")
    suspend fun getSchoolSatScoreListItemWithDbn(@Query("dbn") dbn:String):Response<SchoolSatScoreList>

}