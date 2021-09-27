package com.example.newsifyredesigned.data.remote.dto


import com.example.newsifyredesigned.domain.model.DisplayArticle
import com.google.gson.annotations.SerializedName

data class Article(
    @SerializedName("author")
    val author: String? = null,
    @SerializedName("content")
    val content: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("publishedAt")
    val publishedAt: String = "",
    @SerializedName("source")
    val source: Source = Source(),
    @SerializedName("title")
    val title: String = "",
    @SerializedName("url")
    val url: String = "",
    @SerializedName("urlToImage")
    val urlToImage: String? = null
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