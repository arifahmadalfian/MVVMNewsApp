package com.arifahmadalfian.mvvmnewsapp.core.data.remote.retrofit

import com.arifahmadalfian.mvvmnewsapp.core.data.remote.response.ArticlesItem
import com.arifahmadalfian.mvvmnewsapp.core.data.remote.response.ResponseNews
import com.arifahmadalfian.mvvmnewsapp.core.utils.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") countryCode: String = "us",
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<ResponseNews<List<ArticlesItem>>>

    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<ResponseNews<List<ArticlesItem>>>
}