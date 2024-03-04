package com.dev0kch.learn.presentation.news


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev0kch.learn.presentation.viewmodel.ListNewsViewModel
import com.dev0kch.learn.utils.Constants

@Composable
fun NewsScreen(  newsViewModel : ListNewsViewModel = hiltViewModel()
) {
    val state = newsViewModel.state.value

    LazyColumn(modifier = Modifier.fillMaxSize().padding(Constants.Padding.MediumPadding)){
        items(state.data) { article ->
            NewsItem(article = article)
        }
    }
}


/*@Preview
@Composable
fun NewsScreenPreview() {
    NewsScreen(articles = fackArticles)
}*/