package com.vaibhavmojidra.nycschools.data.model


//Model class / data  class for single School's SAT score data
data class SchoolSatScoreListItem(
    val dbn: String,
    val num_of_sat_test_takers: String,
    val sat_critical_reading_avg_score: String,
    val sat_math_avg_score: String,
    val sat_writing_avg_score: String,
    val school_name: String
)