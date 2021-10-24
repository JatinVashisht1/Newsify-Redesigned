package com.example.newsifyredesigned.domain.use_cases.get_news_by_chip

import com.example.newsifyredesigned.common.Resource
import com.example.newsifyredesigned.data.remote.dto.toDisplayArticle
import com.example.newsifyredesigned.data.remote.dto_chip_response.toDisplayArticle
import com.example.newsifyredesigned.domain.model.DisplayArticle
import com.example.newsifyredesigned.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ChipNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(q: String) : Flow<Resource<List<DisplayArticle>>> = flow{

            try{
                emit(Resource.Loading<List<DisplayArticle>>())
                val news = repository.getNewsByChip(q = q).articles.map { it.toDisplayArticle() }
                emit(Resource.Success<List<DisplayArticle>>(news))
            }
            catch (e: HttpException){
                emit(Resource.Error<List<DisplayArticle>>(message = e.localizedMessage ?: "couldn't reach server. Check your internet connection"))
            }
            catch(e: IOException){
                emit(Resource.Error<List<DisplayArticle>>(message = "couldn't read server. Check your internet connection"))
            }
            catch(e: Exception){
                emit(Resource.Error<List<DisplayArticle>>(message = "couldn't read server. Check your internet connection"))
            }

    }
}