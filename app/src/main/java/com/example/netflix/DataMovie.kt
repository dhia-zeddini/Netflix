package com.example.netflix

import androidx.room.*

@Entity(tableName = "moviedb")
data class DataMovie(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "image")val image:Int,
    @ColumnInfo(name = "name")val name:String,
    @ColumnInfo(name = "desc")val type:String,

    )
