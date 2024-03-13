package com.vaibhavmojidra.nycschools.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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

class MainActivity : ComponentActivity() {

    private val schoolListScreenViewModel:SchoolListScreenViewModel by viewModels{
        SchoolListScreenViewModelFactory(GetSchoolListUseCase(SchoolRepositoryImpl(SchoolDataRetrofitInstance.getRetrofitInstance().create(SchoolDataAPIService::class.java))))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val schoolDataService=SchoolDataRetrofitInstance.getRetrofitInstance().create(SchoolDataService::class.java)

        setContent {


                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(R.color.backgroundColor))) {
                    MainNavHost(schoolListScreenViewModel = schoolListScreenViewModel)

//                    Button(onClick = {
//                        CoroutineScope(Dispatchers.IO).launch {
//                            try {
//                                val response = schoolDataService.getSchoolList()
//                                val schoolList=response.body()?.listIterator()
//                                if(schoolList!=null){
//                                    while (schoolList.hasNext()){
//                                        val schoolListItem=schoolList.next()
//                                        Log.i("MyTag",schoolListItem.school_name)
//                                    }
//                                }else{
//                                    Log.i("MyTag","No Data found")
//                                }
//                            } catch (e: Exception) {
//                                // Handle error
//                                e.printStackTrace()
//                            }

//                            try {
//                                val response = schoolDataService.getSchoolSatScoreListItemWithDbn("01M292")
//                                val schoolSatScoreList=response.body()?.listIterator()
//                                if(schoolSatScoreList!=null){
//                                    while (schoolSatScoreList.hasNext()){
//                                        val schoolSatScoreListItem=schoolSatScoreList.next()
//                                        Log.i("MyTag",schoolSatScoreListItem.school_name)
//                                    }
//                                }else{
//                                    Log.i("MyTag","No Data found")
//                                }
//                            } catch (e: Exception) {
//                                e.printStackTrace()
//                            }
//
//                        }
//                    }) {
//
//                    }
                }

        }
    }
}
