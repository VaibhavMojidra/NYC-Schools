package com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen

import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vaibhavmojidra.nycschools.R
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.presentation.SchoolDetailScreenViewModel
import com.vaibhavmojidra.nycschools.presentation.compose.sharedcompose.TitleBar
import com.vaibhavmojidra.nycschools.presentation.constants.CustomFontFamily

@Composable
fun SchoolDetailScreen(
    navController:NavController,
    schoolDetailScreenViewModel:SchoolDetailScreenViewModel,
    dbn: String,
    schoolName:String,
    schoolLocation:String,
    schoolWebsite: String,
    schoolEmail: String,
    schoolPhoneNumber: String,
    modifier: Modifier=Modifier){

    val satScoreListItemResult=schoolDetailScreenViewModel.satScoreData.collectAsState(initial = Result.Loading).value

    val scrollState= rememberScrollState()

    Column {
        TitleBar(navController,"School Details")
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
        ) {

            LaunchedEffect(key1 = true) {
                schoolDetailScreenViewModel.fetchSATScore("01M292")
                Log.i("MyTag","Triggered data fetch operation for SAT")
            }

            when(satScoreListItemResult){
                is Result.Error -> { Log.i("MyTag","Error: "+satScoreListItemResult.exception.message.toString())}
                Result.Loading -> {}
                is Result.Success -> {
                    Log.i("MyTag",satScoreListItemResult.data.dbn)
                    Log.i("MyTag",satScoreListItemResult.data.school_name)
                }
            }


//            Column(modifier = modifier.padding(20.dp)) {
//                SchoolInfoBlock(schoolName,schoolLocation,schoolWebsite,schoolEmail,schoolPhoneNumber)
//                SATScoreInfoBlock()
//            }
        }
    }
}