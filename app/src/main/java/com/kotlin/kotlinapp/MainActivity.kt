package com.kotlin.kotlinapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.kotlinapp.databinding.ActivityMainBinding
import com.kotlin.kotlinapp.jetpack.binding.DataBindingActivity
import com.kotlin.kotlinapp.jetpack.binding.ViewBindingActivity
import com.kotlin.kotlinapp.jetpack.livedata.LiveDataActivity
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.btnViewBinding.setOnClickListener {
            startActivity(Intent(this, ViewBindingActivity::class.java))
        }
        binding.btnDataBinding.setOnClickListener {
            startActivity(Intent(this, DataBindingActivity::class.java))
        }
        binding.btnLiveData.setOnClickListener {
            startActivity(Intent(this,LiveDataActivity::class.java))
        }
    }
}