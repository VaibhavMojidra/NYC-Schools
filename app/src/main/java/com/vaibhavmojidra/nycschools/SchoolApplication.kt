package com.vaibhavmojidra.nycschools

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


//This will the very first file launched when app opens also this indicates and says hilt to generate all dependency related class injects.
@HiltAndroidApp
class SchoolApplication:Application()