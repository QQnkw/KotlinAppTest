package com.kotlin.kotlinapp.jetpack.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class LiveDataTestViewModel : ViewModel() {
    //创建一个泛型为String的LiveData
    val name: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    //转换 LiveData
//    val age : LiveData<Int> = Transformations.map()
//    val sex : LiveData<Int> = Transformations.switchMap()
}