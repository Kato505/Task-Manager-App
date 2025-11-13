package com.example.taskmanager.dataclass

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Data::class], version = 1)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): Dao
}



