package com.vaibhavmojidra.nycschools.data.repository

import com.vaibhavmojidra.nycschools.data.api.SchoolDataAPIService
import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.data.model.SchoolSatScoreListItem
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.domain.repository.SchoolRepository

class SchoolRepositoryImpl(private val schoolDataAPIService: SchoolDataAPIService) : SchoolRepository {
    override suspend fun getSchoolList(): Result<SchoolList> {
        return try {
            val response = schoolDataAPIService.getSchoolList()
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

        return try {
            val response = schoolDataAPIService.getSchoolSatScoreListItemWithDbn(dbn)
            if(response.isSuccessful){
                val schoolSatScoreList=response.body()
                var schoolSatScoreListItem: SchoolSatScoreListItem? =null
                schoolSatScoreList?.let {
                    if(!it.isEmpty()){
                        schoolSatScoreListItem= it[0]
                    }
                }?: Result.Error(Exception("No SAT Score Found"))
                schoolSatScoreListItem?.let { Result.Success(it) }?:Result.Error(Exception("No SAT Score Found"))
            }else{
                Result.Error(Exception("Failed to fetch SAT data: ${response.message()}"))
            }
        }catch (e:Exception){
            Result.Error(e)
        }
    }


}