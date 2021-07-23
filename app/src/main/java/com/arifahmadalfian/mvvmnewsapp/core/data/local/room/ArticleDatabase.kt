package com.arifahmadalfian.mvvmnewsapp.core.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.arifahmadalfian.mvvmnewsapp.core.data.local.converters.Converters
import com.arifahmadalfian.mvvmnewsapp.core.data.local.entity.Articles

@TypeConverters(
    Converters::class
)
@Database(
    entities = [Articles::class],
    version = 1
)
abstract class ArticleDatabase: RoomDatabase() {

    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: ArticleDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK) {
            INSTANCE ?: createDatabase(context).also { INSTANCE = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}