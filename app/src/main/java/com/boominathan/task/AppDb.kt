package com.boominathan.task

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [(BookEntity::class)],version = 1)
abstract class AppDb : RoomDatabase() {


    abstract fun bookDao(): BookDAO

    companion object {
        private var INSTANCE: AppDb? = null
        fun getInstance(context: Context): AppDb {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDb::class.java,
                    "roomdb"
                ).allowMainThreadQueries()
                    .build()
            }
            return INSTANCE as AppDb
        }
    }



}