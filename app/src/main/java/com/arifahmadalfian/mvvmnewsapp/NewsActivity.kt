package com.arifahmadalfian.mvvmnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.arifahmadalfian.mvvmnewsapp.core.data.local.room.ArticleDatabase
import com.arifahmadalfian.mvvmnewsapp.core.data.repository.NewsRepository
import com.arifahmadalfian.mvvmnewsapp.databinding.NewsActivityBinding
import com.arifahmadalfian.mvvmnewsapp.ui.NewsViewModel
import com.arifahmadalfian.mvvmnewsapp.ui.ViewModelFactory

class NewsActivity : AppCompatActivity() {

    private var _binding: NewsActivityBinding? = null
    private val binding get() = _binding

    lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = NewsActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val repository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        // id dari fragment tidak bisa di binding
        // berpindah dengan menggunakan kode (Navigation.findNavController(this, id fragment di xml))
        // kalau menggunakan kotlin sintetyc bisa dengan newsNavHostFragment.findNavControler()
        binding?.bottomNavigationView
            ?.setupWithNavController(
                Navigation.findNavController(this, R.id.newsNavHostFragment)
            )
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
