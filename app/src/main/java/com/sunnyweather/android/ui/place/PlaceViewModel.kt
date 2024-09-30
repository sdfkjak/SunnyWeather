package com.sunnyweather.android.ui.place


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.sunnyweather.android.logic.Repository

import com.sunnyweather.android.logic.model.Place

class PlaceViewModel : ViewModel(){
    private val searchViewModel = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = searchViewModel.switchMap { query -> Repository.searchPlace(query) }

    fun searchPlaces(query: String){
        searchViewModel.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isSavedPlace()
}