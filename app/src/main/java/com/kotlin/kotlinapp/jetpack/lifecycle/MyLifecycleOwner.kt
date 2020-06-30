package com.kotlin.kotlinapp.jetpack.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class MyLifecycleOwner : LifecycleOwner {
    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

    init {
        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.currentState = Lifecycle.State.CREATED
    }

    fun onStart() {
        lifecycleRegistry.currentState = Lifecycle.State.STARTED
    }
}