package com.example.test_app.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var num : Int = 5


    fun plus() {
        num += 5
    }

    fun getNum() : Int {
        return num
    }



}