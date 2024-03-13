package com.vaibhavmojidra.nycschools.presentation.compose.schoollistscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SchoolListScreen(navigateToNextScreen:()->Unit) {
    Column {
        Button(onClick = { navigateToNextScreen() }) {
            Text(text = "Click")
        }
    }
}