package com.vaibhavmojidra.nycschools.presentation.compose.sharedcompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vaibhavmojidra.nycschools.R


//Reusable composable for custom Title Bar
@Composable
fun TitleBar(navController: NavController,screenTitle:String="Default Screen Title"){
        Row(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = {navController.popBackStack()}) {
                Icon(painter = painterResource(R.drawable.ic_back), contentDescription = null, tint = colorResource(R.color.appPrimaryColor))
            }
            Text(
                text = screenTitle.uppercase(),
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.roboto_medium)),
                modifier = Modifier
                    .padding(end = 16.dp)
                    .weight(1f),
                textAlign = TextAlign.Start,
                color = colorResource(R.color.textColor)
            )
        }
}