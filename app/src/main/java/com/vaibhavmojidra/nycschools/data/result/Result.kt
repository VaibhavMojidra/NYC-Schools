package com.vaibhavmojidra.nycschools.data.result


//Generic sealed class for passing operation(API fetch calls) in result format
sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    data object Loading : Result<Nothing>()
}