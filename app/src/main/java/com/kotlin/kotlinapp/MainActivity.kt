package com.kotlin.kotlinapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.kotlinapp.jetpack.binding.DataBindingActivity
import com.kotlin.kotlinapp.jetpack.binding.ViewBindingActivity
import com.kotlin.kotlinapp.jetpack.livedata.LiveDataActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_view_binding.setOnClickListener {
            startActivity(Intent(this, ViewBindingActivity::class.java))
        }
        btn_data_binding.setOnClickListener {
            startActivity(Intent(this, DataBindingActivity::class.java))
        }
        btn_live_data.setOnClickListener {
            startActivity(Intent(this,LiveDataActivity::class.java))
        }
    }
}