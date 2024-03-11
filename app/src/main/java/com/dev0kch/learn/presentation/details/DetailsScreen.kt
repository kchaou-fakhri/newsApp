package com.dev0kch.learn.presentation.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import com.dev0kch.learn.domain.model.Article

@Composable
fun DetailsScreen(navController: NavHostController, article: Article) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(text = article.toString())
    }
}
