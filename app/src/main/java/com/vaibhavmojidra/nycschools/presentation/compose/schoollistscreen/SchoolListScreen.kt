package com.vaibhavmojidra.nycschools.presentation.compose.schoollistscreen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vaibhavmojidra.nycschools.R
import com.vaibhavmojidra.nycschools.data.model.SchoolListItem
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.presentation.SchoolListScreenViewModel
import com.vaibhavmojidra.nycschools.presentation.compose.sharedcompose.Loader
import com.vaibhavmojidra.nycschools.presentation.constants.CustomFontFamily

@Composable
fun SchoolListScreen(navigateToNextScreen:(schoolListItem:SchoolListItem)->Unit,schoolListScreenViewModel:SchoolListScreenViewModel,modifier: Modifier=Modifier) {

    val context= LocalContext.current

    Column {
        LaunchedEffect(key1 = true) {
            schoolListScreenViewModel.fetchSchoolList()
            Log.i("MyTag","Triggered data fetch operation")
        }

        val schoolListResult=schoolListScreenViewModel.schoolList.collectAsState(initial = Result.Loading).value

        Text(text = "Schools",
            modifier
                .fillMaxWidth()
                .padding(top = 5.dp, bottom = 5.dp, start = 15.dp),
            fontSize = 56.sp,
            fontFamily = CustomFontFamily.SCREEN_TITLE,
            color = colorResource(R.color.textColor))
        when (schoolListResult) {
            is Result.Error -> {
                Toast.makeText(context,schoolListResult.exception.message.toString(),Toast.LENGTH_LONG).show()
            }
            Result.Loading -> {
                Loader()
            }
            is Result.Success -> {
                val schoolList=schoolListResult.data
                SchoolListBlock(schoolList,navigateToNextScreen)
            }
        }

    }
}