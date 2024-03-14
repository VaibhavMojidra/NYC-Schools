package com.vaibhavmojidra.nycschools.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.vaibhavmojidra.nycschools.presentation.compose.schooldetailscreen.SchoolDetailScreen
import com.vaibhavmojidra.nycschools.presentation.compose.schoollistscreen.SchoolListScreen
import com.vaibhavmojidra.nycschools.presentation.constants.Routes


//All the routing that is screens are configured over here for navigation
@Composable
fun AppNavigation(navController:NavHostController= rememberNavController()){
    NavHost(navController=navController, startDestination = Routes.SCHOOL_LIST_SCREEN){

        composable(route=Routes.SCHOOL_LIST_SCREEN){
            val schoolListScreenViewModel:SchoolListScreenViewModel= hiltViewModel()
            SchoolListScreen(navigateToNextScreen = {
                navController.navigate("${Routes.SCHOOL_DETAILS_SCREEN}/${it.dbn}/${it.school_name}/${it.location}/${it.school_email}/${it.phone_number}")
            },schoolListScreenViewModel)
        }

        composable(route="${Routes.SCHOOL_DETAILS_SCREEN}/{dbn}/{school_name}/{location}/{school_email}/{phone_number}", arguments = listOf(
            navArgument("dbn"){
                type= NavType.StringType
            },
            navArgument("school_name"){
                type= NavType.StringType
            },
            navArgument("location"){
                type= NavType.StringType
            },
            navArgument("school_email"){
                type= NavType.StringType
            },
            navArgument("phone_number"){
                type= NavType.StringType
            },
        )){

            val schoolDetailScreenViewModel:SchoolDetailScreenViewModel= hiltViewModel()
            val dbn=it.arguments?.getString("dbn")
            val schoolName=it.arguments?.getString("school_name")
            val schoolLocation=it.arguments?.getString("location")
            val schoolEmail=it.arguments?.getString("school_email")
            val schoolPhoneNumber=it.arguments?.getString("phone_number")

            SchoolDetailScreen(navController,schoolDetailScreenViewModel,dbn!!,schoolName,schoolLocation,schoolEmail,schoolPhoneNumber)
        }


    }
}