package com.example.newsifyredesigned.presentation.detail_screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor() : ViewModel() {
    val urlToImage = mutableStateOf<String>("")
    val content = mutableStateOf<String>("")
    val description = mutableStateOf<String>("")
}