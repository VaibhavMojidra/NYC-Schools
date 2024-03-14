package com.vaibhavmojidra.nycschools.presentation.compose.sharedcompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.vaibhavmojidra.nycschools.R

//Reusable composable for showing loader while data if getting fetched or any other operation
@Composable
fun Loader(modifier: Modifier=Modifier){
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator(modifier=modifier.size(70.dp), color = colorResource(R.color.appPrimaryColor))
    }
}