package com.kotlin.kotlinapp.jetpack.room.entity

import androidx.room.*

/**
 * 实体表的定义
 */
@Fts4//支持全文搜索
@Entity(
    tableName = "BBEntity",//修改表的名称
    ignoredColumns = arrayOf("bb"),//忽略父类传下来的bb字段
    indices = arrayOf(Index(value = ["a", "b"], unique = true))//将 @Index 注释的 unique 属性设为 true 来强制实施此唯一性属性
)
data class BEntity(
    @PrimaryKey @ColumnInfo(name = "rowid") var id: Int,//设置主键;启用 FTS 的表始终使用 INTEGER 类型的主键且列名称为“rowid”
    var a: String?,
    var b: String?,
    @ColumnInfo(name = "CC") var c: String?,//修改在表中的名称
    @Ignore var d: String?//忽略该字段
) : BBase()