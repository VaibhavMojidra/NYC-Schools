package com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen

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
import com.vaibhavmojidra.nycschools.presentation.constants.CustomFontFamily


//This is reusable compose of single row in SAT Score table / data.
@Composable
fun SATScoreDataRow(satSubject:String,satScore:String,modifier: Modifier = Modifier,){
    Row(modifier=modifier.fillMaxWidth()){
        Text(text = satSubject,modifier= modifier
            .padding(vertical = 5.dp)
            .weight(0.5f),fontSize = 18.sp, fontFamily = CustomFontFamily.NORMAL_TEXT,color = colorResource(R.color.textColor)
        )
        Text(text = satScore,modifier= modifier
            .padding(vertical = 5.dp)
            .weight(0.5f),fontSize = 18.sp, fontFamily = CustomFontFamily.NORMAL_TEXT, color = colorResource(R.color.textColor)
        )
    }
}