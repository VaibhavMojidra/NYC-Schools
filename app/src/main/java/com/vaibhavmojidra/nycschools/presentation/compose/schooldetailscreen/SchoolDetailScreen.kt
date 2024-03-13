package com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen

import android.provider.ContactsContract.CommonDataKinds.Email
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
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
import com.vaibhavmojidra.nycschools.presentation.compose.sharedcompose.TitleBar
import com.vaibhavmojidra.nycschools.presentation.constants.CustomFontFamily

@Composable
fun SchoolDetailScreen(
    navController:NavController,
    dbn: String,
    schoolName:String,
    schoolLocation:String,
    schoolWebsite: String,
    schoolEmail: String,
    schoolPhoneNumber: String,
    modifier: Modifier=Modifier){

    val scrollState= rememberScrollState()

    Column {
        TitleBar(navController,"School Details")
        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
        ) {
            Column(modifier = modifier.padding(20.dp)) {
                SchoolInfoBlock(schoolName,schoolLocation,schoolWebsite,schoolEmail,schoolPhoneNumber)
                SATScoreInfoBlock()
            }
        }
    }
}