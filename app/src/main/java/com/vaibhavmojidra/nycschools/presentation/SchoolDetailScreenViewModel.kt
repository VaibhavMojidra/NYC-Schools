package com.vaibhavmojidra.nycschools.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaibhavmojidra.nycschools.data.model.SchoolSatScoreListItem
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.domain.usecase.GetSchoolSATScoreUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class SchoolDetailScreenViewModel(private val getSchoolSATScoreUseCase: GetSchoolSATScoreUseCase):ViewModel() {

    private val _satScoreData= MutableStateFlow<Result<SchoolSatScoreListItem>>(Result.Loading)
    val satScoreData get()=_satScoreData

    fun fetchSATScore(dbn:String){
        viewModelScope.launch(Dispatchers.IO){
            _satScoreData.value=getSchoolSATScoreUseCase(dbn)
        }
    }
}