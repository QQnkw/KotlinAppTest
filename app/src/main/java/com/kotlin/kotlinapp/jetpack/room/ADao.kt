package com.kotlin.kotlinapp.jetpack.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kotlin.kotlinapp.jetpack.room.entity.AEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ADao {
    @Query("SELECT * FROM AEntity")
    fun getAll(): List<AEntity>

    @Query("SELECT * FROM aentity WHERE uid IN (:aIds)")
    fun loadAllByIds(aIds: IntArray): List<AEntity>

    /*没有这个表,会导致运行失败
    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): AEntity*/

    @Insert
    fun insertAll(vararg users: AEntity)

    @Delete
    fun delete(user: AEntity)

    @Query("SELECT * FROM AEntity")
    fun getAList(): Flow<List<AEntity>>

    @Query("SELECT a1 FROM AEntity")
    suspend fun getFirstField(): List<String>?
}