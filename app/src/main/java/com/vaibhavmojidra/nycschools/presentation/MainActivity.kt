package com.vaibhavmojidra.nycschools.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import com.vaibhavmojidra.nycschools.R
import com.vaibhavmojidra.nycschools.data.api.SchoolDataRetrofitInstance
import com.vaibhavmojidra.nycschools.data.api.SchoolDataService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val schoolDataService=SchoolDataRetrofitInstance.getRetrofitInstance().create(SchoolDataService::class.java)

        setContent {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(color = colorResource(R.color.backgroundColor))) {
//                    MainNavHost()

                    Button(onClick = {
                        CoroutineScope(Dispatchers.IO).launch {
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

                            try {
                                val response = schoolDataService.getSchoolSatScoreListItemWithDbn("01M292")
                                val schoolSatScoreList=response.body()?.listIterator()
                                if(schoolSatScoreList!=null){
                                    while (schoolSatScoreList.hasNext()){
                                        val schoolSatScoreListItem=schoolSatScoreList.next()
                                        Log.i("MyTag",schoolSatScoreListItem.school_name)
                                    }
                                }else{
                                    Log.i("MyTag","No Data found")
                                }
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }

                        }
                    }) {

                    }
                }

        }
    }
}
