package com.example.newsifyredesigned.presentation

sealed class Screen(val route: String){
    object HomeScreen : Screen ("HomeScreenRoute")
    object DetailScreen : Screen ("DetailScreenRoute")
}
