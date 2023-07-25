package com.example.testtask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    private var _count = MutableLiveData(0)
    val count: LiveData<Int>
        get() = _count

    fun addCount() {
        _count.value = _count.value?.plus(1)
    }

}