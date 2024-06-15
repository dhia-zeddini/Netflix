package com.example.netflix

import androidx.room.*

@Dao
interface MovieDao {

    @Query("SELECT * FROM moviedb")
    fun getAll(): MutableList<DataMovie>

    @Query("SELECT * FROM moviedb WHERE id IN (:id)")
    fun loadById(id: Int): DataMovie

    @Insert
    fun insertGame( movie: DataMovie)

    @Delete
    fun delete(movie: DataMovie)
}