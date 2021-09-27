package com.example.newsifyredesigned.presentation.news_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun LoadImage(url: String){

    Card(modifier = Modifier.fillMaxWidth()
        .height(300.dp)){
        Image(
            painter = rememberImagePainter(data = url),
            contentDescription = null,

            modifier = Modifier.fillMaxSize()
        )
    }
}
@ExperimentalCoilApi
@Composable
fun NewsImageLoading(url: String) {
    Card(modifier = Modifier.fillMaxWidth()
        .height(300.dp)){
        Image(
            painter = rememberImagePainter(data = url),
            contentDescription = null,

            modifier = Modifier.fillMaxSize()
        )
    }
}