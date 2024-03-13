package com.vaibhavmojidra.nycschools.domain.repository

import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.data.result.Result
interface SchoolRepository {
    suspend fun getSchoolList(): Result<SchoolList>
}