package com.kotlin.kotlinapp.jetpack.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AEntity(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "a1") val a: String?,
    @ColumnInfo val b: String?
)