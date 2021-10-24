package com.example.newsifyredesigned.data.remote.dto_chip_response


import com.example.newsifyredesigned.domain.model.DisplayArticle
import com.google.gson.annotations.SerializedName

data class ChipResponseDto(
    @SerializedName("articles")
    val articles: List<Article> = listOf(),
    @SerializedName("status")
    val status: String = "",
    @SerializedName("totalResults")
    val totalResults: Int = 0
)

