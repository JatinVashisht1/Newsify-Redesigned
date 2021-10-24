package com.example.newsifyredesigned.presentation.news_list

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.newsifyredesigned.presentation.news_list.components.CustomTextField
import com.example.newsifyredesigned.presentation.news_list.components.NewsChips
import com.example.newsifyredesigned.presentation.news_list.components.NewsListItem
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@ExperimentalCoilApi
@Composable
fun NewsListScreen(
    viewModel: NewsListViewModel = hiltViewModel(),
    context: Context,
    navController: NavController
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val searchTerm = viewModel.currentSelectedChip.value
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            androidx.compose.material.TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .clickable {
                            scope.launch(IO) {
                                scaffoldState.drawerState.open()
                            }
                        }
                )
                CustomTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterVertically)
                        .padding(start = 8.dp),
                    searchTerm = searchTerm
                ){
                   viewModel._currentSelectedChip.value = it
                }
            }
        },
        drawerContent = {
            Text(text = "Newsify", modifier = Modifier.padding(16.dp))
            Divider(modifier = Modifier.padding(4.dp))
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Sign in",
                    modifier = Modifier.padding(8.dp)

                )
            }

        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NewsChips(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(8.dp)
            )
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.news) { news ->
                        NewsListItem(news = news, navController = navController)
                    }
                }

                if (state.error.isNotBlank()) {
                    Text(
                        text = state.error,
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                            .align(Alignment.Center)
                    )
                }

                if (state.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    }
}