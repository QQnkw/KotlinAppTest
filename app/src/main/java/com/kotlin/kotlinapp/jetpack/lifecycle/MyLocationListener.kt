package com.kotlin.kotlinapp.jetpack.lifecycle

import android.content.Context
import android.location.Location
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent

/**
 * 这里默认类实现了LifecycleObserver
 */
internal class MyLocationListener(
    private val context: Context,
    private val lifecycle: Lifecycle,
    private val callback: (Location) -> Unit
) {

    private var enabled = false

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun start() {
        if (enabled) {
            // connect
        }
    }

    fun enable() {
        enabled = true
        //检查生命周期
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            // connect if not connected
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stop() {
        // disconnect if connected
    }
}