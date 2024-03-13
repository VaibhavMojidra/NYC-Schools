package com.vaibhavmojidra.nycschools.presentation.compose.schoollistscreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.data.model.SchoolListItem

@Composable
fun SchoolListBlock(schoolList:SchoolList, navigateToNextScreen:(schoolListItem: SchoolListItem)->Unit, modifier:Modifier=Modifier){
    LazyColumn(
        modifier.fillMaxSize()) {
        items(schoolList, key = {schoolItem->schoolItem.dbn}){ schoolListItem ->
            SchoolListItemRow(schoolListItem,navigateToNextScreen)
        }
    }
}