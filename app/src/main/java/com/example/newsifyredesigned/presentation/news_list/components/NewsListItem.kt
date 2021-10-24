package com.example.newsifyredesigned.presentation.news_list.components

import android.content.Context
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.estimateAnimationDurationMillis
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.newsifyredesigned.domain.model.DisplayArticle
import com.example.newsifyredesigned.presentation.Screen

@ExperimentalCoilApi
@Composable
fun NewsListItem(news: DisplayArticle, navController: NavController) {
    val expanded = rememberSaveable { mutableStateOf(false) }
    val snackbarState = rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(8.dp)
            .wrapContentHeight()
    ) {

        Card(elevation = 16.dp,
            modifier = Modifier
                .animateContentSize(tween(300, easing = FastOutLinearInEasing))
                .clickable { expanded.value = !expanded.value }
//                .shadow(16.dp, shape = RectangleShape)
                .padding(8.dp)
        ) {
            Column {
                news.urlToImage?.let { LoadImage(url = it, 250f) }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = if (!expanded.value) news.title.toString() else news.description.toString(),
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.padding(4.dp),
                            fontWeight = if (!expanded.value) FontWeight.Bold else FontWeight.SemiBold
                        )
                    }
                }
            }
        }
        Divider(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 18.dp, bottom = 4.dp))
    }
}