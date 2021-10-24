package com.example.newsifyredesigned.data.remote.dto_chip_response


import com.example.newsifyredesigned.domain.model.DisplayArticle
import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("content")
    val content: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("source")
    val source: Source = Source(),
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val urlToImage: String = ""
)

fun Article.toDisplayArticle() : DisplayArticle{
    return DisplayArticle(
        author = author,
        title = title,
        description = description,
        content = content,
        urlToImage = urlToImage
    )
}