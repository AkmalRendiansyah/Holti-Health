package com.holtihealth.app.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.holtihealth.app.database.Article
import com.holtihealth.app.database.ArticleRepository
import com.holtihealth.app.database.HistoryRepository
import com.holtihealth.app.database.HistoryWithDisease

class HomeViewModel(private val articleRepository: ArticleRepository, private val historyRepository: HistoryRepository) : ViewModel() {

    fun getAllArticles(): LiveData<List<Article>> = articleRepository.getAllArticles()

    fun allHistoryWithDisease() : LiveData<List<HistoryWithDisease>> = historyRepository.getAllHistoryWithDiseaseHome()
}