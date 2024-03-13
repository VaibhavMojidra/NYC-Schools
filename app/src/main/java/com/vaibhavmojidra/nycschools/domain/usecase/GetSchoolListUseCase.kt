package com.vaibhavmojidra.nycschools.domain.usecase

import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.domain.repository.SchoolRepository
import com.vaibhavmojidra.nycschools.data.result.Result
class GetSchoolListUseCase(private val schoolRepository: SchoolRepository) {
    suspend operator fun invoke():Result<SchoolList> = schoolRepository.getSchoolList()
}