package com.holtihealth.app.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.holtihealth.app.database.HistoryRepository
import com.holtihealth.app.database.HistoryWithDisease

class HistoryViewModel(private val repository: HistoryRepository) : ViewModel() {
    val allHistoryWithDisease : LiveData<List<HistoryWithDisease>> = repository.getAllHistoryWithDisease()
}