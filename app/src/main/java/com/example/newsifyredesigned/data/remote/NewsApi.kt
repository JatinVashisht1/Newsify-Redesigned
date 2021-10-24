package com.example.newsifyredesigned.data.remote

import com.example.newsifyredesigned.data.remote.dto.NewsResponse
import com.example.newsifyredesigned.data.remote.dto_chip_response.ChipResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getNews(
        @Query("country") country : String = "in",
        @Query("apiKey") apiKey: String = "02479e165c314b149d9bbc249dc24e6f") : NewsResponse

    @GET("everything")
    suspend fun getNewsByChip(
        @Query ("q") q: String,
        @Query ("sortBy") sortBy: String = "publishedAt",
        @Query ("apiKey") apiKey: String = "02479e165c314b149d9bbc249dc24e6f"
    ) : ChipResponseDto
}

//https://newsapi.org/v2/everything?q=tesla&from=2021-09-24&sortBy=publishedAt&apiKey=02479e165c314b149d9bbc249dc24e6f
