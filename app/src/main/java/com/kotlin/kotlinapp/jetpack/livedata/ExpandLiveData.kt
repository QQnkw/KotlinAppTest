package com.kotlin.kotlinapp.jetpack.livedata

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData

/**
 * 自定义的LiveData
 * 如果观察者的生命周期处于 STARTED 或 RESUMED 状态，则 LiveData 会认为该观察者处于活跃状态;
 * setValue(T) 方法将更新 LiveData 实例的值，并将更改通知给任何活跃观察者
 */
class ExpandLiveData(name: String) : LiveData<Int>() {
//    private val stockManager = StockManager(name)//某种服务

    private val listener = { num: Int ->
        value = num
    }

    /**
     * 当 LiveData 对象具有活跃观察者时，会调用 onActive() 方法。
     */
    override fun onActive() {
//        stockManager.requestPriceUpdates(listener)
    }

    /**
     * 当 LiveData 对象没有任何活跃观察者时，会调用 onInactive() 方法。
     * 由于没有观察者在监听，因此没有理由与 StockManager 服务保持连接。
     */
    override fun onInactive() {
//        stockManager.removeUpdates(listener)
    }

    //可以在多个 Activity、Fragment 和 Service 之间共享这些对象。为使示例保持简单，您可以将 LiveData 类实现为单一实例
    companion object {
        private lateinit var sInstance: ExpandLiveData

        @MainThread
        fun get(name: String): ExpandLiveData {
            sInstance = if (::sInstance.isInitialized) sInstance else ExpandLiveData(name)
            return sInstance
        }
    }
}