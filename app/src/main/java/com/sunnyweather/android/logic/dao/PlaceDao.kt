package com.sunnyweather.android.logic.dao

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.sunnyweather.android.SunnyWeatherApplication
import com.sunnyweather.android.logic.model.Place

object PlaceDao {
    private fun sharedPreferences() = SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

    fun savePlace(place: Place){
        sharedPreferences().edit().apply {
            putString("place", Gson().toJson(place))
            apply()
        }
        Log.d("PlaceDao", sharedPreferences().getString("place", "").toString())
    }

    fun getSavedPlace(): Place{
        val placeJson = sharedPreferences().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")

}