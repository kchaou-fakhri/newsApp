package com.dev0kch.learn.presentation.news


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.dev0kch.learn.presentation.news.components.CategoryItem
import com.dev0kch.learn.presentation.news.components.NewsItem
import com.dev0kch.learn.presentation.news.components.TopNewsItem
import com.dev0kch.learn.presentation.viewmodel.ListNewsViewModel
import com.dev0kch.learn.utils.Constants

@Composable
fun NewsScreen(
    newsViewModel: ListNewsViewModel = hiltViewModel()
) {
    val state = newsViewModel.state.value


    Column(modifier = Modifier.fillMaxSize()) {

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(Constants.RoundedCorner.ImageRoundedCorner))

                .padding(Constants.Padding.MediumPadding, bottom = Constants.Padding.MediumPadding)
        ) {
            items(state.data) { article ->
                TopNewsItem(article)
            }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Constants.Padding.MediumPadding)
        ) {
            items(Constants.categories) { category ->
                CategoryItem(
                    category = category,
                    onClick = {},
                    modifier = Modifier.height(Constants.Width.SmallX)
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Constants.Padding.MediumPadding)
        ) {
            items(state.data) { article ->
                NewsItem(article = article)
            }
        }
    }


}


@Preview
@Composable
fun NewsScreenPreview() {
    NewsScreen()
}