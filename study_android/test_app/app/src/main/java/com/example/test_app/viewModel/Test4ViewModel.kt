package com.example.test_app.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.test_app.adapter.GiftAdapter
import com.example.test_app.data.GiftData
import kotlin.properties.Delegates

class Test4ViewModel : ViewModel() {

    private var _itemList = MutableLiveData<ArrayList<GiftData>>()  //mutable 변경하는 한 값
    val itemList : LiveData<ArrayList<GiftData>> //관찰가능
        get() = _itemList

    var item = arrayListOf<GiftData>()

    fun btnClicked(items :  GiftData){
      item.add(items)
        _itemList.value = item //live 데이터를 입력된 item 데이터로 변견

    }
}