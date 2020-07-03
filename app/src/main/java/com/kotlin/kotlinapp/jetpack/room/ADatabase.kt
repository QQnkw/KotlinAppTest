package com.kotlin.kotlinapp.jetpack.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kotlin.kotlinapp.jetpack.room.entity.AEntity

@Database(entities = arrayOf(AEntity::class), version = 1)
abstract class ADatabase : RoomDatabase() {
    abstract fun aDao(): ADao
}