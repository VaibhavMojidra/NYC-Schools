package com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vaibhavmojidra.nycschools.R

@Composable
fun SATScoreInfoBlock(modifier:Modifier=Modifier){
    Column(modifier= modifier
        .fillMaxWidth()
        .padding(vertical = 20.dp)) {

        Text(text = "SAT Score", modifier= modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth(),fontSize = 24.sp, color = colorResource(R.color.textColor)
        )

        SATScoreDataRow("Reading","355")
        SATScoreDataRow("Writing","355")
        SATScoreDataRow("Math","355")

    }
}