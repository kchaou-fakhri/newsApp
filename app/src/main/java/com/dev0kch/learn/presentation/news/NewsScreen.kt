package com.dev0kch.learn.presentation.news


import android.util.Log
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.dev0kch.learn.presentation.navigation.Route
import com.dev0kch.learn.presentation.news.components.CategoryItem
import com.dev0kch.learn.presentation.news.components.NewsItem
import com.dev0kch.learn.presentation.news.components.TopNewsItem
import com.dev0kch.learn.presentation.viewmodel.ListNewsViewModel
import com.dev0kch.learn.presentation.viewmodel.SharedViewModel
import com.dev0kch.learn.utils.Constants

@Composable
fun NewsScreen(
    navController: NavHostController,
    newsViewModel: ListNewsViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel
) {
    val state = newsViewModel.state.value
    Log.d("data", state.data.toString())

    Column(modifier = Modifier.fillMaxSize()) {

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(Constants.RoundedCorner.ImageRoundedCorner))

                .padding(Constants.Padding.MediumPadding, bottom = Constants.Padding.MediumPadding)
        ) {
            items(state.data) { article ->
                TopNewsItem(article) {
//                    navController.currentBackStackEntry?.savedStateHandle?.set(
//                        key = Configuration.ARTICLE_PARAM,
//                        value = article
//                    )
                    sharedViewModel.addArticle(article)
                    navController.navigate(route = Route.DetailsScreen.route )
                }
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


