package com.arifahmadalfian.mvvmnewsapp.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseNews<T>(

	@field:SerializedName("totalResults")
	val totalResults: Int,

	@field:SerializedName("articles")
	val articles: T,

	@field:SerializedName("status")
	val status: String
)

