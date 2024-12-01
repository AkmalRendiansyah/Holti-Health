package com.holtihealth.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.holtihealth.app.database.ArticleRepository
import com.holtihealth.app.database.DiseaseRepository
import com.holtihealth.app.ui.article.ArticleViewModel
import com.holtihealth.app.ui.scan.ResultViewModel

class ViewModelFactory(
    private val diseaseRepository: DiseaseRepository? = null,
    private val articleRepository: ArticleRepository? = null
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ResultViewModel(diseaseRepository!!) as T
        } else if (modelClass.isAssignableFrom(ArticleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ArticleViewModel(articleRepository!!) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}