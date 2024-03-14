package com.vaibhavmojidra.nycschools.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaibhavmojidra.nycschools.data.model.SchoolSatScoreListItem
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.domain.usecase.GetSchoolSATScoreUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//View model for managing data and ui related data manipulations for lifecycle School Detail Screen
@HiltViewModel
class SchoolDetailScreenViewModel @Inject constructor(private val getSchoolSATScoreUseCase: GetSchoolSATScoreUseCase):ViewModel() {

    private val _satScoreData= MutableStateFlow<Result<SchoolSatScoreListItem>>(Result.Loading)

    val satScoreData get()=_satScoreData

    fun fetchSATScore(dbn:String){
        _satScoreData.value=Result.Loading
        viewModelScope.launch(Dispatchers.IO){
            _satScoreData.value=getSchoolSATScoreUseCase(dbn)
        }
    }
}