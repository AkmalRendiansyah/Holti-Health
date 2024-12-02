package com.holtihealth.app.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    @Insert
    suspend fun insertHistory(history: History)

    @Query("SELECT * FROM history ORDER BY scanTime DESC")
    fun getAllHistory(): LiveData<List<History>>

    @Query("SELECT * FROM history WHERE id = :historyId")
    fun getHistoryById(historyId: Int): LiveData<HistoryWithDisease>

    @Query("SELECT * FROM history")
    fun getAllHistoryWithDisease(): LiveData<List<HistoryWithDisease>>
}
