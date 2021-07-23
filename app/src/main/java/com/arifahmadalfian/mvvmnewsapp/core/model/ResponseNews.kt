package com.arifahmadalfian.mvvmnewsapp.core.model

import com.google.gson.annotations.SerializedName

data class ResponseNews<T>(

	@field:SerializedName("totalResults")
	val totalResults: Int,

	@field:SerializedName("articles")
	val articles: T,

	@field:SerializedName("status")
	val status: String
)

