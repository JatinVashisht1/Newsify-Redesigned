package com.example.newsifyredesigned.domain.repository

import com.example.newsifyredesigned.data.remote.dto.Article

interface NewsRepository {
    suspend fun getHeadlines() : List<Article>
}