package com.kotlin.kotlinapp.jetpack.room.entity

import androidx.room.*

/**
 * 表一对多的关系
 * */
@Entity
data class OneParentEntity(@PrimaryKey val oneParentId: Int)

@Entity
data class MoreSonEntity(@PrimaryKey val moreSonId: Int)

data class OneToMore(
    @Embedded val oneParent: OneParentEntity,
    @Relation(
        parentColumn = "oneParentId",
        entityColumn = "oneParentCreatorId"
    )
    var moreSonList: List<MoreSonEntity>
)

/**
 * 将下列方法添加dao中
 * 会多次查询,为保原子操作,需加transaction注解
 */
@Transaction
@Query("SELECT * FROM OneParentEntity")
fun getOneToMore(): List<OneToMore>{
    return emptyList()
}