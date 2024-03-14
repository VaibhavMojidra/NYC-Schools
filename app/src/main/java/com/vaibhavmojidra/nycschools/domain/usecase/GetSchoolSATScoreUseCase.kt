package com.vaibhavmojidra.nycschools.domain.usecase

import com.vaibhavmojidra.nycschools.domain.repository.SchoolRepository

class GetSchoolSATScoreUseCase(private val schoolRepository: SchoolRepository) {
    suspend operator fun invoke(dbn:String)=schoolRepository.getSATScore(dbn)
}