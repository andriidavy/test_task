package com.example.testtask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CountViewModelFactory() :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CountViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}