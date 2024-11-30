package com.holtihealth.app.ui.article

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.holtihealth.app.database.Article
import com.holtihealth.app.database.ArticleRepository
import com.holtihealth.app.database.ArticleRoomDatabase
import kotlinx.coroutines.launch

class ArticleViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ArticleRepository

    init {
        // Initialize the repository with the ArticleDao from the database
        val articleDao = ArticleRoomDatabase.getInstance(application).articleDao()
        repository = ArticleRepository(articleDao)
        viewModelScope.launch {
            repository.addDefaultArticles()
        }
    }

    // Function to fetch all articles
    fun getAllArticles(): LiveData<List<Article>> = repository.getAllArticles()
}
