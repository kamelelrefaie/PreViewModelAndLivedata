package com.example.previewmodelandlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var counter = 0

    fun increaseNumber() {
        viewModelScope.launch {
            for (i in 1..5) {
                counter += 1
                delay(1000)
            }
        }
    }
}