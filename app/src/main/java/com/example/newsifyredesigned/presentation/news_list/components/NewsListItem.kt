package com.example.newsifyredesigned.presentation.news_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.Coil
import coil.annotation.ExperimentalCoilApi
import com.example.newsifyredesigned.domain.model.DisplayArticle

@ExperimentalCoilApi
@Composable
fun NewsListItem(news: DisplayArticle) {
    Column(modifier = Modifier
        .padding(8.dp)){

        Card(elevation = 16.dp) {
        news.urlToImage?.let { LoadImage(url = it) }
            Row(
                modifier = Modifier
                    .fillMaxWidth()

//                    .padding(0.dp)
                ,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = news.title.toString(),
                    style = MaterialTheme.typography.body1,
                    overflow = TextOverflow.Ellipsis,
//            color = Color.White
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Divider()
            }
        }
    }




}