package com.example.msgapp.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity("Messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val content: String,
    val timestamp: Long
)