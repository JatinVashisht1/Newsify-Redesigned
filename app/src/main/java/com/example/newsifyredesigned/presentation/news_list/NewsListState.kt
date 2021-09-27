package com.example.newsifyredesigned.presentation.news_list

import com.example.newsifyredesigned.domain.model.DisplayArticle

data class NewsListState(
val isLoading: Boolean = false,
val news:List<DisplayArticle> = listOf(),
val error: String = ""

)
