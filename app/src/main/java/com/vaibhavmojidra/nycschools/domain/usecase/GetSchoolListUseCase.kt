package com.vaibhavmojidra.nycschools.domain.usecase

import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.domain.repository.SchoolRepository
import com.vaibhavmojidra.nycschools.data.result.Result
import javax.inject.Inject


//UseCase class to invoke the getSchoolList() and get results of school's list data
class GetSchoolListUseCase @Inject constructor(private val schoolRepository: SchoolRepository) {
    suspend operator fun invoke():Result<SchoolList> = schoolRepository.getSchoolList()
}