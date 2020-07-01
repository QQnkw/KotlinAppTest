package com.kotlin.kotlinapp.jetpack.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class A(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "a1") val a: String?,
    @ColumnInfo val b: String?
)