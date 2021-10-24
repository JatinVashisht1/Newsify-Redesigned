package com.example.newsifyredesigned.domain.repository

import com.example.newsifyredesigned.data.remote.dto.Article
import com.example.newsifyredesigned.data.remote.dto_chip_response.ChipResponseDto

interface NewsRepository {
    suspend fun getHeadlines() : List<Article>
    suspend fun getNewsByChip(q: String) : ChipResponseDto
}