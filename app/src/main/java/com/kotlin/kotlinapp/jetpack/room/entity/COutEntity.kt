package com.kotlin.kotlinapp.jetpack.room.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Fts4
import androidx.room.PrimaryKey

@Fts4
@Entity
data class COutEntity(
    @PrimaryKey val rowid: Int,
    val a: String?,
    @Embedded(prefix = "inner_") val inData: CInnerEntity?
)
//对象嵌套生成表,生成的表字段为rowid,a,inner_a,inner_b,inner_c