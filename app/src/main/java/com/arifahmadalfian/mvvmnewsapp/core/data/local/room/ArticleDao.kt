package com.arifahmadalfian.mvvmnewsapp.core.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.arifahmadalfian.mvvmnewsapp.core.model.Articles

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Articles): Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): LiveData<List<Articles>>

    @Delete
    suspend fun deleteArticle(article: Articles)
}