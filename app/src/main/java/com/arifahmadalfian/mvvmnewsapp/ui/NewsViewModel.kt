package com.arifahmadalfian.mvvmnewsapp.ui

import androidx.lifecycle.ViewModel
import com.arifahmadalfian.mvvmnewsapp.core.data.repository.NewsRepository

class NewsViewModel(
    val newsRepository: NewsRepository
): ViewModel() {
}