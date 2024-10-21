package com.example.blogs

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavHost() {
    val navController= rememberNavController()
    val viewModel: HomeViewModel= viewModel()

    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            ArticlesHome(navController, viewModel)
        }
        composable("detail") {
            ArticlesDetail(navController, viewModel)
        }
    }
}
