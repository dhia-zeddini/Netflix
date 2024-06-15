package com.example.netflix

import android.content.Context
import androidx.room.*

@Database(entities = [DataMovie::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun movieDao(): MovieDao

    companion object {
        private var instance: AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context): AppDataBase {
            if (instance == null) {
                synchronized(AppDataBase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java,
                        "moviedb"
                    ).build()
                }
            }
            return instance!!
        }
    }

}