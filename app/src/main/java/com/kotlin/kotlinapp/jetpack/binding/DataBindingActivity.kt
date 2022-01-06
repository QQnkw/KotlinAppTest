package com.kotlin.kotlinapp.jetpack.binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kotlin.kotlinapp.R
import com.kotlin.kotlinapp.bean.User
import com.kotlin.kotlinapp.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDataBindingBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        binding.user =User()

        //如果您要在 Fragment、ListView 或 RecyclerView 适配器中使用数据绑定项，
        // 您可能更愿意使用绑定类或 DataBindingUtil 类的 inflate() 方法，如以下代码示例所示：
//        val listItemBinding = ListItemBinding.inflate(layoutInflater, viewGroup, false)
        // or
//        val listItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, viewGroup, false)
    }
}