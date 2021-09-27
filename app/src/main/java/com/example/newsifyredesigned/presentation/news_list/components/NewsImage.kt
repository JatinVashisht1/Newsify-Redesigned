package com.example.newsifyredesigned.presentation.news_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun LoadImage(url: String){

    Box(modifier = Modifier.fillMaxWidth()
        .height(250.dp)) {
        Column {


            Image(
                painter = rememberImagePainter(data = url),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )



        }
    }
}
