package com.example.newsifyredesigned.presentation.detail_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.Coil
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.newsifyredesigned.presentation.news_list.components.LoadImage

@ExperimentalCoilApi
@Composable
fun DetailScreen(
    urlToImage: String? = null,
    content: String? = null,
    description: String? = null,
    viewModel: DetailScreenViewModel = hiltViewModel()
) {
    if (content != null) {
        viewModel.content.value = content
    }

    if (urlToImage != null) {
        viewModel.urlToImage.value = urlToImage
    }

    if (description != null) {
        viewModel.description.value = description
    }

    val urlToImageText = viewModel.urlToImage.value
    val contentText = viewModel.content.value
    val descriptionText  = viewModel.description.value

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
        ){
            Image(
                painter = rememberImagePainter(data = urlToImageText),
                contentDescription = null,
                modifier = Modifier.wrapContentSize()
            )
        }
        Text(text = contentText, style = MaterialTheme.typography.body1, modifier = Modifier.padding(16.dp))
    }
}