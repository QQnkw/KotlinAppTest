package com.kotlin.kotlinapp.jetpack.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.kotlin.kotlinapp.jetpack.room.entity.AEntity

@Database(entities = arrayOf(AEntity::class), version = 1,exportSchema = false)
abstract class ADatabase : RoomDatabase() {
    abstract fun aDao(): ADao
}
val MIGRATION_1_2 = object :Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        // TODO: 2020/7/7 版本迁移路径 
    }

}