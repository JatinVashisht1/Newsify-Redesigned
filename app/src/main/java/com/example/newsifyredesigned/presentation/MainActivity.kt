package com.example.newsifyredesigned.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsifyredesigned.presentation.detail_screen.DetailScreen
import com.example.newsifyredesigned.presentation.news_list.NewsListScreen
import com.example.newsifyredesigned.presentation.ui.theme.NewsifyRedesignedTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsifyRedesignedTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ){
                        composable(Screen.HomeScreen.route){
                            NewsListScreen(context = this@MainActivity, navController = navController)
                        }
                        composable(
                            route = Screen.DetailScreen.route + "?urlToImage={urlToImage}&content={content}&description={description}",
                            arguments = listOf(
                                navArgument("urlToImage"){defaultValue = "null"},
                                navArgument("content"){defaultValue = "null"},
                                )
                        ){
                            DetailScreen(
                                urlToImage = it.arguments?.getString("urlToImage"),
                                content = it.arguments?.getString("content"),
                            )
                        }
                    }
                }
            }
        }
    }
}