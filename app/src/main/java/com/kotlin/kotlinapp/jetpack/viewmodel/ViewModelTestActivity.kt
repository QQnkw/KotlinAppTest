package com.kotlin.kotlinapp.jetpack.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.kotlin.kotlinapp.R
import com.kotlin.kotlinapp.bean.User

class ViewModelTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_test)
        val model: FirstViewModel by viewModels()
        model.getUsers().observe(this, Observer<List<User>> { userList: List<User> ->
            userList.forEach {

            }
        })
    }
}