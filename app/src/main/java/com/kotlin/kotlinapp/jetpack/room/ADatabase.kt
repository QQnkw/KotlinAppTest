package com.kotlin.kotlinapp.jetpack.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(A::class), version = 1)
abstract class ADatabase : RoomDatabase() {
    abstract fun aDao(): ADao
}