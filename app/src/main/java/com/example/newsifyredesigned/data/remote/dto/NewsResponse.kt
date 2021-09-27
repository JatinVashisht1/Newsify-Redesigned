package com.example.newsifyredesigned.data.remote.dto


import com.example.newsifyredesigned.domain.model.DisplayArticle
import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("articles")
    val articles: List<Article> = listOf(),
    @SerializedName("status")
    val status: String = "",
    @SerializedName("totalResults")
    val totalResults: Int = 0
)

