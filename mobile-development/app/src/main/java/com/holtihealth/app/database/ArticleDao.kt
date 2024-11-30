package com.holtihealth.app.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(article: Article)
    @Update
    fun update(article: Article)
    @Delete
    fun delete(article: Article)
    @Query("SELECT * from article ORDER BY id ASC")
    fun getAllArticles(): LiveData<List<Article>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(articles: List<Article>)
}