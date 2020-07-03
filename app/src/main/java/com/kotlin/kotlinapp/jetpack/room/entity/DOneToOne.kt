package com.kotlin.kotlinapp.jetpack.room.entity

import androidx.room.*

/**
 * 表一对一的关系
 * */
@Entity
data class ParentEntity(@PrimaryKey val parentId: Int)

@Entity
data class SonEntity(@PrimaryKey val sonId: Int)

data class OneToOne(
    @Embedded val parent: ParentEntity,
    @Relation(
        parentColumn = "parentId",
        entityColumn = "parentOwnerId"
    )
    val son: SonEntity
)

/**
 * 将下列方法添加dao中
 * 会多次查询,为保原子操作,需加transaction注解
 */
@Transaction
@Query("SELECT * FROM ParentEntity")
fun getOneToOne(): List<OneToOne> {
    return emptyList()
}

