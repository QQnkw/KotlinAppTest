package com.kotlin.kotlinapp.jetpack.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ADao {
    @Query("SELECT * FROM a")
    fun getAll(): List<A>

    @Query("SELECT * FROM a WHERE uid IN (:aIds)")
    fun loadAllByIds(aIds: IntArray): List<A>

    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): A

    @Insert
    fun insertAll(vararg users: A)

    @Delete
    fun delete(user: A)
}