package com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


//Composable for data or can say main block of displaying data in School detail list screen
@Composable
fun SchoolDetailDataBlock(schoolName:String?,
                          schoolLocation:String?,
                          schoolEmail: String?,
                          schoolPhoneNumber: String?,
                          isSATScoreDataAvailable:Boolean=false,
                          readingScore:String,
                          writingScore:String,
                          mathScore:String,
                          modifier:Modifier=Modifier){
    val scrollState= rememberScrollState()
    Column(modifier = modifier
        .fillMaxSize()
        .verticalScroll(scrollState)
    ) {
        Column(modifier = modifier.padding(20.dp)) {
            SchoolInfoBlock(schoolName,schoolLocation,schoolEmail,schoolPhoneNumber)
            SATScoreInfoBlock(isSATScoreDataAvailable,readingScore,writingScore,mathScore)
        }
    }
}