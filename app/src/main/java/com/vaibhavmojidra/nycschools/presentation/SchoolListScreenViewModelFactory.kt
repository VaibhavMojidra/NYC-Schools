package com.vaibhavmojidra.nycschools.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vaibhavmojidra.nycschools.domain.usecase.GetSchoolListUseCase

class SchoolListScreenViewModelFactory(private val getSchoolListUseCase: GetSchoolListUseCase):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = SchoolListScreenViewModel(getSchoolListUseCase) as T
}