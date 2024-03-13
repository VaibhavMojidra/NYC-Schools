package com.vaibhavmojidra.nycschools.presentation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen.SchoolDetailScreen
import com.vaibhavmojidra.nycschools.presentation.compose.schoollistscreen.SchoolListScreen
import com.vaibhavmojidra.nycschools.presentation.constants.Routes

@Composable
fun MainNavHost(navController:NavHostController= rememberNavController(),schoolListScreenViewModel: SchoolListScreenViewModel){
    NavHost(navController=navController, startDestination = Routes.SCHOOL_LIST_SCREEN){
        composable(route=Routes.SCHOOL_LIST_SCREEN){
            SchoolListScreen(navigateToNextScreen = {
               navController.navigate("${Routes.SCHOOL_DETAILS_SCREEN}/${it.dbn}/${it.school_name}/${it.location}/${it.website}/${it.school_email}/${it.phone_number}")
            },schoolListScreenViewModel)
        }

        composable(route="${Routes.SCHOOL_DETAILS_SCREEN}/{dbn}/{school_name}/{location}/{website}/{school_email}/{phone_number}", arguments = listOf(
            navArgument("dbn"){
                type= NavType.StringType
            },
            navArgument("school_name"){
                type= NavType.StringType
            },
            navArgument("location"){
                type= NavType.StringType
            },
            navArgument("website"){
                type= NavType.StringType
            },
            navArgument("school_email"){
                type= NavType.StringType
            },
            navArgument("phone_number"){
                type= NavType.StringType
            },
        )){

            val dbn=it.arguments?.getString("dbn")
            val schoolName=it.arguments?.getString("school_name")
            val schoolLocation=it.arguments?.getString("location")
            val schoolWebsite=it.arguments?.getString("website")
            val schoolEmail=it.arguments?.getString("school_email")
            val schoolPhoneNumber=it.arguments?.getString("phone_number")
            SchoolDetailScreen(navController,dbn!!,schoolName!!,schoolLocation!!,schoolWebsite!!,schoolEmail!!,schoolPhoneNumber!!)
        }
    }
}