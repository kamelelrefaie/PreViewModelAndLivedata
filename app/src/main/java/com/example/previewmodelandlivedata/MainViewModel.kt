package com.example.previewmodelandlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    private val _counter = MutableLiveData(0)
    val counter:LiveData<Int> = _counter

    fun increaseNumber() {
        viewModelScope.launch {
            for (i in 1..5) {
                _counter.value = _counter.value!! + 1
                delay(1000)
            }
        }
    }


}