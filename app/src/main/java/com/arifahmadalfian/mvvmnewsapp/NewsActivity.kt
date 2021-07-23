package com.arifahmadalfian.mvvmnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.arifahmadalfian.mvvmnewsapp.databinding.NewsActivityBinding

class NewsActivity : AppCompatActivity() {

    private var _binding: NewsActivityBinding? = null
    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = NewsActivityBinding.inflate(layoutInflater)
        setContentView(binding?.root)

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
