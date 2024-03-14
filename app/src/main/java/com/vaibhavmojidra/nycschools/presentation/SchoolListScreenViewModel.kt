package com.vaibhavmojidra.nycschools.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.domain.usecase.GetSchoolListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


//View model for managing data and ui related data manipulations for lifecycle School List Screen
@HiltViewModel
class SchoolListScreenViewModel @Inject constructor(private val getSchoolListUseCase: GetSchoolListUseCase) :
    ViewModel() {
    private val _schoolList = MutableStateFlow<Result<SchoolList>>(Result.Loading)
    val schoolList: StateFlow<Result<SchoolList>> get() = _schoolList

    fun fetchSchoolList() {
        viewModelScope.launch(Dispatchers.IO) {
            _schoolList.value = getSchoolListUseCase()
        }
    }
}