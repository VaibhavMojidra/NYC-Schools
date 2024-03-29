package com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import com.vaibhavmojidra.nycschools.R
import com.vaibhavmojidra.nycschools.presentation.constants.CustomFontFamily


//School info's block in school detail screen excluding school sat score
@Composable
fun SchoolInfoBlock(schoolName:String?,
                    schoolLocation:String?,
                    schoolEmail: String?,
                    schoolPhoneNumber: String?,
                    modifier: Modifier = Modifier){
    Column {
        //Text to show school's name
        schoolName?.let { Text(text = schoolName, fontSize = 24.sp, color = colorResource(
            R.color.textColor)
        )}
        //Text to show school's location
        schoolLocation?.let { Text(text = schoolLocation,color = colorResource(
            R.color.lighterTextColor), fontFamily = CustomFontFamily.THIN_TEXT, fontSize = 14.sp) }

        //Text to show school's email
        schoolEmail?.let {
            Text(text = schoolEmail,color = colorResource(R.color.lighterTextColor), fontFamily = CustomFontFamily.THIN_TEXT, fontSize = 14.sp)
        }

        //Text to show school's phone number
        schoolPhoneNumber?.let {
            Text(text = schoolPhoneNumber,color = colorResource(R.color.lighterTextColor), fontFamily = CustomFontFamily.THIN_TEXT, fontSize = 14.sp)
        }
    }
}