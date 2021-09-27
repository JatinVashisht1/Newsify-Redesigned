package com.example.newsifyredesigned.presentation.news_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsifyredesigned.common.Resource
import com.example.newsifyredesigned.domain.use_cases.get_news.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
private val getNewsUseCase: GetNewsUseCase
)    : ViewModel() {
    private val _state = mutableStateOf<NewsListState>(NewsListState())
    val state: State<NewsListState> = _state

    init{
        getNews()
    }

    private fun getNews() {
        getNewsUseCase().onEach {result->

            when(result){
                is Resource.Success ->{
                    _state.value = result.data?.let { NewsListState(news = it) }!!
                }

                is Resource.Error ->{
                    _state.value = NewsListState(error = result.message!!)
                }

                is Resource.Loading ->{
                    _state.value = NewsListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }
}