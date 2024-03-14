package com.vaibhavmojidra.nycschools.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vaibhavmojidra.nycschools.domain.usecase.GetSchoolSATScoreUseCase

class SchoolDetailScreenViewModelFactory(private val getSchoolSATScoreUseCase: GetSchoolSATScoreUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = SchoolDetailScreenViewModel(getSchoolSATScoreUseCase) as T
}