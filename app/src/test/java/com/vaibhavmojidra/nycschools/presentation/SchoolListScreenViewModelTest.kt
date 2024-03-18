package com.vaibhavmojidra.nycschools.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vaibhavmojidra.nycschools.data.model.SchoolList
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.domain.usecase.GetSchoolListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`


class SchoolListScreenViewModelTest{
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var schoolListScreenViewModel: SchoolListScreenViewModel
    private lateinit var mockGetSchoolListUseCase:GetSchoolListUseCase

    @Before
    fun setUp(){
        mockGetSchoolListUseCase=mock(GetSchoolListUseCase::class.java)
        schoolListScreenViewModel= SchoolListScreenViewModel(mockGetSchoolListUseCase)
    }

    @Test
    fun testFetchSchoolList_Success()= runBlocking(CoroutineScope(Dispatchers.IO).coroutineContext){
        val mockSchoolList=SchoolList()

        `when`(mockGetSchoolListUseCase.invoke()).thenReturn(Result.Success(mockSchoolList))

        schoolListScreenViewModel.fetchSchoolList()


        assert(schoolListScreenViewModel.schoolList.value == Result.Loading)
        delay(1000)
        assert(schoolListScreenViewModel.schoolList.value == Result.Success(mockSchoolList))
    }

    @Test
    fun testFetchSchoolList_Error()= runBlocking(CoroutineScope(Dispatchers.IO).coroutineContext){
        val exception=Exception("Failed to fetch schools")

        `when`(mockGetSchoolListUseCase.invoke()).thenReturn(Result.Error(exception))

        schoolListScreenViewModel.fetchSchoolList()

        assert(schoolListScreenViewModel.schoolList.value == Result.Loading)
        delay(1000)
        assert(schoolListScreenViewModel.schoolList.value == Result.Error(exception))
    }
}