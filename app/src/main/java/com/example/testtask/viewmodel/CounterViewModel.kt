package com.example.testtask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

//CounterViewModel inherits the AndroidViewModel to create a single instance for an activity and a fragment
class CounterViewModel(application: Application) : AndroidViewModel(application) {

    private var _counter = MutableLiveData(0)
    val counter: LiveData<Int>
        get() = _counter

    fun increaseCounter() {
        _counter.value = _counter.value?.inc()
    }
}
