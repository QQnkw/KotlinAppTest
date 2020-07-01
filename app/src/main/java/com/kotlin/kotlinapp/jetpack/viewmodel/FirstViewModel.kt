package com.kotlin.kotlinapp.jetpack.viewmodel

import androidx.lifecycle.*
import com.kotlin.kotlinapp.bean.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FirstViewModel : ViewModel() {
    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    private fun loadUsers() {
        //异步操作获取用户
    }

    private val user: LiveData<User> = liveData {
//        emit()//发送
    }

    private val userId: LiveData<String> = MutableLiveData()
    private val otherUser = userId.switchMap { userId: String ->
        liveData(context = viewModelScope.coroutineContext + Dispatchers.IO) {
            emit(User())
        }
    }
}