package com.vaibhavmojidra.nycschools.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.vaibhavmojidra.nycschools.R
import com.vaibhavmojidra.nycschools.data.api.SchoolDataAPIService
import com.vaibhavmojidra.nycschools.data.api.SchoolDataRetrofitInstance
import com.vaibhavmojidra.nycschools.data.repository.SchoolRepositoryImpl
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.domain.repository.SchoolRepository
import com.vaibhavmojidra.nycschools.domain.usecase.GetSchoolListUseCase
import com.vaibhavmojidra.nycschools.domain.usecase.GetSchoolSATScoreUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val schoolDataAPIService: SchoolDataAPIService=SchoolDataRetrofitInstance.getRetrofitInstance().create(SchoolDataAPIService::class.java)
    private val schoolRepositoryImpl:SchoolRepositoryImpl=SchoolRepositoryImpl(schoolDataAPIService)
    private val schoolListScreenViewModel: SchoolListScreenViewModel by viewModels {
        SchoolListScreenViewModelFactory(GetSchoolListUseCase(schoolRepositoryImpl))
    }

    private val schoolDetailScreenViewModel:SchoolDetailScreenViewModel by viewModels {
        SchoolDetailScreenViewModelFactory(GetSchoolSATScoreUseCase(schoolRepositoryImpl))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(R.color.backgroundColor))
            ) {
                MainNavHost(schoolListScreenViewModel = schoolListScreenViewModel,
                    schoolDetailScreenViewModel = schoolDetailScreenViewModel
                )
            }
        }
    }
}

