package com.kotlin.kotlinapp.jetpack.room.entity

import androidx.room.*

/**
 * 表多对多的关系
 * */
@Entity
data class MoreParentEntity(@PrimaryKey val moreParentId: Int)

@Entity
data class FMoreSonEntity(@PrimaryKey val fmoreSonId: Int)

@Entity(primaryKeys = ["moreParentId", "fmoreSonId"])
data class MoreToMore(val moreParentId: Int, val fmoreSonId: Int)

data class SonListWithParent(
    @Embedded val moreParent: MoreParentEntity,
    @Relation(
        parentColumn = "moreParentId",
        entityColumn = "sonId",
        associateBy = Junction(MoreToMore::class)
    )
    val sonList: List<FMoreSonEntity>
)

data class ParentListWithSon(
    @Embedded val fMoreSon: FMoreSonEntity,
    @Relation(
        parentColumn = "fmoreSonId",
        entityColumn = "parentId",
        associateBy = Junction(MoreToMore::class)
    )
    val parentList: List<MoreParentEntity>
)

/**
 * 将下列方法添加dao中
 * 会多次查询,为保原子操作,需加transaction注解
 */
@Transaction
@Query("SELECT * FROM MoreParentEntity")
fun getSonListWithParent(): List<SonListWithParent>{
    return emptyList()
}

@Transaction
@Query("SELECT * FROM FMoreSonEntity")
fun getParentListWithSon(): List<ParentListWithSon>{
    return emptyList()
}