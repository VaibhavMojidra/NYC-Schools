package com.vaibhavmojidra.nycschools.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen.SchoolDetailScreen
import com.vaibhavmojidra.nycschools.presentation.compose.schoollistscreen.SchoolListScreen

@Composable
fun MainNavHost(navController:NavHostController= rememberNavController()){
    NavHost(navController=navController, startDestination = "school_list_screen"){
        composable(route="school_list_screen"){
            SchoolListScreen(navigateToNextScreen = {
                navController.navigate("school_detail_screen")
            })
        }

        composable(route="school_detail_screen"){
            SchoolDetailScreen(navController)
        }
    }
}