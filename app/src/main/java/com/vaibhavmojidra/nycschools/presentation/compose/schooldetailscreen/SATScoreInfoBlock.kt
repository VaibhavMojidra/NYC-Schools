package com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vaibhavmojidra.nycschools.R
import com.vaibhavmojidra.nycschools.presentation.constants.CustomFontFamily

//This compose showing the SAT score data
@Composable
fun SATScoreInfoBlock(isSATScoreDataAvailable:Boolean=false,readingScore:String,writingScore:String,mathScore:String,modifier:Modifier=Modifier){
    Column(modifier= modifier
        .fillMaxWidth()
        .padding(vertical = 20.dp)) {

        Text(text = "SAT Score", modifier= modifier
            .padding(vertical = 5.dp)
            .fillMaxWidth(),fontSize = 24.sp, color = colorResource(R.color.textColor)
        )

        //When we got SAT Score of the school
        if(isSATScoreDataAvailable){
            SATScoreDataRow("Reading",readingScore)
            SATScoreDataRow("Writing",writingScore)
            SATScoreDataRow("Math",mathScore)
        }
        //If no data found
        else{

            Text(text = "SAT score unavailable",modifier= modifier
                .padding(vertical = 5.dp)
                .fillMaxWidth(),fontSize = 18.sp, fontFamily = CustomFontFamily.THIN_TEXT, color = colorResource(R.color.lighterTextColor)
            )
        }

    }
}