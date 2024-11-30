package com.holtihealth.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Article::class], version = 1)
abstract class ArticleRoomDatabase : RoomDatabase() {
    abstract fun articleDao(): ArticleDao

    companion object {
        @Volatile
        private var instance: ArticleRoomDatabase? = null
        fun getInstance(context: Context): ArticleRoomDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    ArticleRoomDatabase::class.java, "Article.db"
                ).build().also { instance = it }
            }
    }
}