package com.vaibhavmojidra.nycschools.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vaibhavmojidra.nycschools.data.model.SchoolSatScoreListItem
import com.vaibhavmojidra.nycschools.data.result.Result
import com.vaibhavmojidra.nycschools.domain.usecase.GetSchoolSATScoreUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class SchoolDetailScreenViewModelTest{
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var schoolDetailScreenViewModel: SchoolDetailScreenViewModel
    private lateinit var mockGetSchoolSATScoreUseCase:GetSchoolSATScoreUseCase

    @Before
    fun setUp(){
        mockGetSchoolSATScoreUseCase=mock(GetSchoolSATScoreUseCase::class.java)
        schoolDetailScreenViewModel=SchoolDetailScreenViewModel(mockGetSchoolSATScoreUseCase)
    }

    @Test
    fun testFetchFetchSATScore_Success()= runBlocking(CoroutineScope(Dispatchers.IO).coroutineContext){
        val satScoreData=SchoolSatScoreListItem("11012","","","","","")
        `when`(mockGetSchoolSATScoreUseCase.invoke("11012")).thenReturn(Result.Success(satScoreData))

        schoolDetailScreenViewModel.fetchSATScore("11012")

        assert(schoolDetailScreenViewModel.satScoreData.value == Result.Loading)
        delay(1000)
        assert(schoolDetailScreenViewModel.satScoreData.value == Result.Success(satScoreData))
    }

    @Test
    fun testFetchFetchSATScore_Error()= runBlocking(CoroutineScope(Dispatchers.IO).coroutineContext){
        val exception=Exception("Failed to fetch SAT data")
        `when`(mockGetSchoolSATScoreUseCase.invoke("11012")).thenReturn(Result.Error(exception))

        schoolDetailScreenViewModel.fetchSATScore("11012")

        assert(schoolDetailScreenViewModel.satScoreData.value == Result.Loading)
        delay(1000)
        assert(schoolDetailScreenViewModel.satScoreData.value == Result.Error(exception))
    }
}