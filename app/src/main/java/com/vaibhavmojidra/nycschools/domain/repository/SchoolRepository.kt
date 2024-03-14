package com.vaibhavmojidra.nycschools.domain.repository

import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.data.model.SchoolSatScoreListItem
import com.vaibhavmojidra.nycschools.data.result.Result

//This interface provide a skeleton structure of what functions and what should be their return type for the data fetch functions
interface SchoolRepository {
    suspend fun getSchoolList(): Result<SchoolList>

    suspend fun getSATScore(dbn:String):Result<SchoolSatScoreListItem>
}