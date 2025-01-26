package com.example.msgapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.msgapp.data.local.database.Message
import kotlinx.coroutines.flow.Flow

@Dao
interface  MessageDAO {

    @Query("SELECT * FROM Messages ORDER BY timestamp ASC")
    fun getAllMessages(): Flow<List<Message>>

    @Insert
    suspend fun insertMessage(message: Message)


}