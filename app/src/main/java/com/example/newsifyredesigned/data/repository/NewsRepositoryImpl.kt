package com.example.newsifyredesigned.data.repository

import com.example.newsifyredesigned.data.remote.NewsApi
import com.example.newsifyredesigned.data.remote.dto.Article
import com.example.newsifyredesigned.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val api: NewsApi
) : NewsRepository{
    override suspend fun getHeadlines(): List<Article> {
        return api.getNews().articles
    }
}