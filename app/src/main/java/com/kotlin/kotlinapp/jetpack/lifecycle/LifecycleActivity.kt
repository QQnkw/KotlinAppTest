package com.kotlin.kotlinapp.jetpack.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleRegistry
import com.kotlin.kotlinapp.R

/**
 * 生命周期管理
 * 尝试管理整个应用进程的生命周期，请参阅 ProcessLifecycleOwner
 */
class LifecycleActivity : AppCompatActivity() {
    private lateinit var myLocationListener: MyLocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        myLocationListener = MyLocationListener(this, lifecycle) { location ->
            // update UI
        }
        MyLifecycleOwner()
    }
}