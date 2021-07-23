package com.arifahmadalfian.mvvmnewsapp.core.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.arifahmadalfian.mvvmnewsapp.core.data.remote.response.Source

@Entity(
    tableName = "articles"
)
data class Articles(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val publishedAt: String,
    val author: String,
    val urlToImage: String,
    val description: String,
    val source: Source,
    val title: String,
    val url: String,
    val content: String
)
