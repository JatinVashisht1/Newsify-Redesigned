package com.example.newsifyredesigned.presentation.news_list.components

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

@Composable
fun ShowSnackbar(message: String) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        ) {
        scope.launch(IO) {
            scaffoldState.snackbarHostState.showSnackbar(message)
        }
    }
}