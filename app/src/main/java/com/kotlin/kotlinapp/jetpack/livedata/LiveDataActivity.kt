package com.kotlin.kotlinapp.jetpack.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.kotlin.kotlinapp.R
import com.kotlin.kotlinapp.databinding.ActivityLiveDataBinding
import java.util.*

class LiveDataActivity : AppCompatActivity() {
    // Use the 'by viewModels()' Kotlin property delegate from the activity-ktx artifact
    private val model: LiveDataTestViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLiveDataBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        // Other code to setup the activity...

        // 创建观察者更新UI
        val observer = Observer<String> { name ->
            //在这种情况下,更新文本UI
            binding.textView.text = name
        }
        //观察LiveData,通过活动作为LifecycleOwner和观察者
        model.name.observe(this, observer)

        //更新 LiveData 对象.
        /**
         * 您必须调用 setValue(T) 方法以从主线程更新 LiveData 对象。
         * 如果在 worker 线程中执行代码，则您可以改用 postValue(T) 方法来更新 LiveData 对象。
         */
        binding.button.setOnClickListener {
            val num = Random().nextInt(100)
            val newName: String = "小明" + num
            model.name.value = newName
        }
        //自定义的LiveData使用
        ExpandLiveData.get("xiao").observe(this, Observer<Int> { num: Int? ->
            // do something
        })
    }
}