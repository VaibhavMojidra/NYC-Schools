package com.vaibhavmojidra.nycschools.data.repository

import com.vaibhavmojidra.nycschools.data.api.SchoolDataAPIService
import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.data.model.SchoolSatScoreListItem
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.domain.repository.SchoolRepository


//Implementation of repository class to fetch data from remote data source using retrofit and returning in a structured format.
class SchoolRepositoryImpl(private val schoolDataAPIService: SchoolDataAPIService) : SchoolRepository {

    //To fetch school's list making retrofit call
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

    //To fetch particular school's SAT Score with dbn number making retrofit call with query
    override suspend fun getSATScore(dbn: String): Result<SchoolSatScoreListItem> {

        return try {
            val response = schoolDataAPIService.getSchoolSatScoreListItemWithDbn(dbn)
            if(response.isSuccessful){
                // As the response is in list format taking 0 index that is first value of list fetch as there will always single element list or empty list
                val schoolSatScoreList=response.body()
                if(schoolSatScoreList.isNullOrEmpty()){
                    Result.Error(Exception("No SAT Score Found"))
                } else {
                    Result.Success(schoolSatScoreList.first())
                }
            }else{
                Result.Error(Exception("Failed to fetch SAT data: ${response.message()}"))
            }
        }catch (e:Exception){
            Result.Error(e)
        }
    }


}