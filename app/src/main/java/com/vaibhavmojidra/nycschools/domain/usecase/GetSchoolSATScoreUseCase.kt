package com.vaibhavmojidra.nycschools.domain.usecase

import com.vaibhavmojidra.nycschools.domain.repository.SchoolRepository
import javax.inject.Inject

//UseCase class to invoke the getSchoolList() and get results of school's SAT score data
class GetSchoolSATScoreUseCase @Inject constructor(private val schoolRepository: SchoolRepository) {
    suspend operator fun invoke(dbn:String)=schoolRepository.getSATScore(dbn)
}