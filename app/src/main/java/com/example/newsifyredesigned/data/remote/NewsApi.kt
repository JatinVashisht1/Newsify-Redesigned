package com.example.newsifyredesigned.data.remote

import com.example.newsifyredesigned.data.remote.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country : String = "in",
        @Query("apiKey") apiKey: String = "02479e165c314b149d9bbc249dc24e6f") : NewsResponse
}
