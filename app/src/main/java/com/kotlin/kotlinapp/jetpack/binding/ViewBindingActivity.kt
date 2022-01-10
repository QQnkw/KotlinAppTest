package com.kotlin.kotlinapp.jetpack.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.kotlinapp.databinding.ActivityViewBindingBinding

/**
 * 视图绑定activity
 */
class ViewBindingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}