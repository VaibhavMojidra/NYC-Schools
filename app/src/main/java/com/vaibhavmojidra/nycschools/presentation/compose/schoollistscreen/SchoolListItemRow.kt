package com.vaibhavmojidra.nycschools.presentation.compose.schoollistscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vaibhavmojidra.nycschools.R
import com.vaibhavmojidra.nycschools.data.model.SchoolListItem
import com.vaibhavmojidra.nycschools.presentation.constants.CustomFontFamily

//Composable to show single school list item of schools list in School List Screen
@Composable
fun SchoolListItemRow(
    schoolListItem: SchoolListItem,
    navigateToNextScreen:(schoolListItem:SchoolListItem)->Unit,
    modifier: Modifier=Modifier){

    Column(modifier.fillMaxWidth()) {
        Row(modifier= modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {navigateToNextScreen(schoolListItem)},
        ) {
            Text(
                text = schoolListItem.school_name,
                fontSize = 20.sp,
                color = colorResource(R.color.textColor),
                fontFamily = CustomFontFamily.NORMAL_TEXT
            )
        }
        Spacer(modifier = modifier
            .height(1.dp)
            .background(colorResource(R.color.screenDividerColor))
            .fillMaxWidth())
    }
}