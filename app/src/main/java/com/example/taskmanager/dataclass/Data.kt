package com.example.taskmanager.dataclass

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity
@Parcelize
data class Data(
    @PrimaryKey (autoGenerate = true)
    val id: Int,
    val title: String,
    val description : String,
    val date: String

    ): Parcelable