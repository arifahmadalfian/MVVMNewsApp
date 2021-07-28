package com.arifahmadalfian.mvvmnewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.arifahmadalfian.mvvmnewsapp.R
import com.arifahmadalfian.mvvmnewsapp.ui.NewsViewModel

class ArticleFragment: Fragment(R.layout.fragment_article) {

    val viewModel: NewsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}