package com.dev0kch.learn.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dev0kch.learn.domain.model.Article
import com.dev0kch.learn.presentation.details.DetailsScreen
import com.dev0kch.learn.presentation.news.NewsScreen

@Composable
fun HomeNavigation(startDestination: String) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        composable(route = Route.HomeScreen.route) {
            NewsScreen(navController)
        }

        composable(route = Route.DetailsScreen.route) {
            val result =
                navController
                    .previousBackStackEntry
                    ?.savedStateHandle
                    ?.get<Article>(Configuration.ARTICLE_PARAM)



            DetailsScreen(navController, result!!)
        }
    }
}