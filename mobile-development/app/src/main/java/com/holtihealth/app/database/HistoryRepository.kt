package com.holtihealth.app.database

import androidx.lifecycle.LiveData

class HistoryRepository(private val historyDao: HistoryDao) {

    suspend fun insertHistory(history: History) {
        historyDao.insertHistory(history)
    }

    fun getAllHistoryWithDisease(): LiveData<List<HistoryWithDisease>> = historyDao.getAllHistoryWithDisease()

    fun getHistoryDetail(historyId: Int): LiveData<HistoryWithDisease> {
        return historyDao.getHistoryById(historyId)
    }

    suspend fun deleteHistory(historyId: Int) {
        historyDao.deleteHistoryById(historyId)
    }
}
