package com.dev0kch.learn.presentation.details.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import coil.compose.AsyncImage
import com.dev0kch.learn.R
import com.dev0kch.learn.common.checkImage
import com.dev0kch.learn.domain.model.Category
import com.dev0kch.learn.presentation.news.components.CategoryItem
import com.dev0kch.learn.utils.Constants

@Composable
fun ArticleImage(imageUrl: String, category: Category) {
    Box(
        modifier = Modifier
            .height(Constants.Width.X5Large)
            .fillMaxWidth()
            .padding(Constants.Padding.MediumPadding, end = Constants.Padding.SmallPadding)
    ) {
        AsyncImage(
            model = checkImage(imageUrl),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(Constants.RoundedCorner.ImageRoundedCorner))
        )

        Column(
            horizontalAlignment = Alignment.End,
            modifier = Modifier
                .padding(top = Constants.Width.XSmall, end = Constants.Width.Small)
                .fillMaxSize()
                .fillMaxWidth()
        ) {
            CategoryItem(
                category = category,
                onClick = { /*TODO*/ },
                backgroundColor = Color.White,
                textColor = colorResource(
                    id = R.color.primary
                ),
                modifier = Modifier
                    .padding(start = Constants.Width.Small, top = Constants.Width.SmallX)
                    .height(Constants.Width.SmallX)

            )


        }


    }
}