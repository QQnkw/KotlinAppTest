package com.kotlin.kotlinapp.jetpack.room

import android.content.Context
import androidx.room.Room

class B {
    fun getADao(context: Context): ADatabase {
        val db = Room.databaseBuilder(context, ADatabase::class.java, "database-name").build()
        return db
    }
}