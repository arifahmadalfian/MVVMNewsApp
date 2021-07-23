package com.arifahmadalfian.mvvmnewsapp.core.data.remote.retrofit

import com.arifahmadalfian.mvvmnewsapp.core.utils.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    
    private val retrofit by lazy {
        val logging = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    
    val api: NewsAPI by lazy {
        retrofit.create(NewsAPI::class.java)
    }
}