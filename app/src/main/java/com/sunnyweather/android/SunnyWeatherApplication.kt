package com.sunnyweather.android

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application(){
    companion object{
        const val TOKEN = "vjJJTYzZNxapXGDW"
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        var times = 0
    }

    override fun onCreate(){
        super.onCreate()
        context = applicationContext
    }
}