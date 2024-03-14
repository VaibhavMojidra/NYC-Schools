package com.vaibhavmojidra.nycschools.data.repository

import com.vaibhavmojidra.nycschools.data.api.SchoolDataAPIService
import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.data.model.SchoolSatScoreListItem
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.domain.repository.SchoolRepository

class SchoolRepositoryImpl(private val schoolDataAPIService: SchoolDataAPIService) : SchoolRepository {
    override suspend fun getSchoolList(): Result<SchoolList> {
        val response = schoolDataAPIService.getSchoolList()
        return try {
            if (response.isSuccessful) {
               val schoolList=response.body()
               schoolList?.let { Result.Success(it) } ?: Result.Error(Exception("No schools Found"))
            } else {
                Result.Error(Exception("Failed to fetch schools: ${response.message()}"))
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun getSATScore(dbn: String): Result<SchoolSatScoreListItem> {
        TODO("Not yet implemented")
    }


}