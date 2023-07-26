package com.example.testtask.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//CountViewModel inherits the AndroidViewModel to create a single instance for an activity and a fragment
class CountViewModel(application: Application) : AndroidViewModel(application) {
    private var _count = MutableLiveData(0)
    val count: LiveData<Int>
        get() = _count

    fun addCount() {
        _count.value = _count.value?.plus(1)
    }

    fun resetCounter() {
        _count.value = 0
    }
}
