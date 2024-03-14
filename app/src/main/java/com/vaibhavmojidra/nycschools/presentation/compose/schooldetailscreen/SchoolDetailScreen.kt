package com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.presentation.SchoolDetailScreenViewModel
import com.vaibhavmojidra.nycschools.presentation.compose.sharedcompose.Loader
import com.vaibhavmojidra.nycschools.presentation.compose.sharedcompose.TitleBar


//Composable School Detail screen all the composable related to School Detail screen are linked from here.
@Composable
fun SchoolDetailScreen(
    navController:NavController,
    schoolDetailScreenViewModel:SchoolDetailScreenViewModel,
    dbn: String,
    schoolName:String?,
    schoolLocation:String?,
    schoolEmail: String?,
    schoolPhoneNumber: String?,
    modifier: Modifier=Modifier){

    val satScoreListItemResult=schoolDetailScreenViewModel.satScoreData.collectAsState(initial = Result.Loading).value

    Column {
        TitleBar(navController,"School Details")
        LaunchedEffect(key1 = true) {
            schoolDetailScreenViewModel.fetchSATScore(dbn)
            Log.i("MyTag","Triggered data fetch operation for SAT")
        }
        when(satScoreListItemResult){
            is Result.Error -> SchoolDetailDataBlock(schoolName, schoolLocation, schoolEmail, schoolPhoneNumber, false, "", "" , "")
            Result.Loading -> Loader()
            is Result.Success -> {
                val satScoreData=satScoreListItemResult.data
                SchoolDetailDataBlock(schoolName, schoolLocation, schoolEmail, schoolPhoneNumber, true, satScoreData.sat_critical_reading_avg_score, satScoreData.sat_writing_avg_score, satScoreData.sat_math_avg_score)
            }
        }

    }
}