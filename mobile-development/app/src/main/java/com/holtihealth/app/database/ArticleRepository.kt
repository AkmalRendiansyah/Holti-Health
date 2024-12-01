package com.holtihealth.app.database

class ArticleRepository(private val articleDao: ArticleDao) {

    fun getAllArticles() = articleDao.getAllArticles()

}
