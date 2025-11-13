package com.example.taskmanager.dataclass

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface Dao {

    @Insert
    fun addUser(user: Data)

    @Update
    fun updateUser(user: Data)

    @Delete
    fun delete(user: Data)


    @Query("SELECT * FROM Data")
    fun getAllUser(): List<Data>


}