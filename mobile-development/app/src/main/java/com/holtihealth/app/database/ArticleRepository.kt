package com.holtihealth.app.database

import androidx.lifecycle.LiveData

class ArticleRepository(private val articleDao: ArticleDao) {

    fun getAllArticles() = articleDao.getAllArticles()
    fun getArticleDetail(eventId: Int): LiveData<Article> {
        return articleDao.getEventById(eventId)
    }
}
