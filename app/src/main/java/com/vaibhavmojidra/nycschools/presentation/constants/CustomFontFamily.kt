package com.vaibhavmojidra.nycschools.presentation.constants

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import com.vaibhavmojidra.nycschools.R


//Constants for sharing font family across the app
class CustomFontFamily {
    companion object{
        val SCREEN_TITLE= FontFamily(Font(R.font.roboto_medium))
        val NORMAL_TEXT= FontFamily(Font(R.font.roboto_regular))
        val THIN_TEXT= FontFamily(Font(R.font.roboto_thin))
    }
}