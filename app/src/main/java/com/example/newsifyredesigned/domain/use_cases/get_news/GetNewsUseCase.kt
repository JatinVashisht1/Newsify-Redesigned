package com.example.newsifyredesigned.domain.use_cases.get_news

import com.example.newsifyredesigned.common.Resource
import com.example.newsifyredesigned.data.remote.dto.toDisplayArticle
import com.example.newsifyredesigned.domain.model.DisplayArticle
import com.example.newsifyredesigned.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
private val repository: NewsRepository
) {
    operator fun invoke() : Flow<Resource<List<DisplayArticle>>> = flow{
        try{
            emit(Resource.Loading<List<DisplayArticle>>())
            val news = repository.getHeadlines().map{ it.toDisplayArticle() }
            emit(Resource.Success<List<DisplayArticle>>(news))
        }
        catch (e: HttpException){
            emit(Resource.Error<List<DisplayArticle>>(message = e.localizedMessage ?: e.toString()))
        }
        catch(e: IOException){
            emit(Resource.Error<List<DisplayArticle>>(message = "couldn't read server. Check your internet connection"))
        }
        catch(e: Exception){
            emit(Resource.Error<List<DisplayArticle>>(message = e.toString()))
        }
    }
}