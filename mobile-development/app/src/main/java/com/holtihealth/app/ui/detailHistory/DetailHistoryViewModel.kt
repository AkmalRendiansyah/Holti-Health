package com.holtihealth.app.ui.detailHistory

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.holtihealth.app.database.History
import com.holtihealth.app.database.HistoryRepository
import com.holtihealth.app.database.HistoryWithDisease

class DetailHistoryViewModel (private val historyRepository: HistoryRepository, historyId: Int) : ViewModel(){
    val getDetail : LiveData<HistoryWithDisease> = historyRepository.getHistoryDetail(historyId)
}