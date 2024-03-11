package com.dev0kch.learn.presentation.news.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import com.dev0kch.learn.R
import com.dev0kch.learn.common.checkImage
import com.dev0kch.learn.common.refactoringText
import com.dev0kch.learn.domain.model.Article
import com.dev0kch.learn.utils.Constants

@Composable
fun TopNewsItem(article: Article, onItemClick: (article : Article) -> Unit) {

    Box(
        modifier = Modifier
            .height(Constants.Width.X5Large)
            .width(Constants.Width.X30Large)
            .clip(RoundedCornerShape(Constants.RoundedCorner.ImageRoundedCorner))
            .padding(Constants.Padding.MediumPadding, end = Constants.Padding.SmallPadding)
            .clickable { onItemClick(article) }

    ) {
        AsyncImage(
            model = checkImage(article.image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(Constants.RoundedCorner.ImageRoundedCorner))
        )

        Column(
            modifier = Modifier
                .padding(top = Constants.Width.Medium)
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            colorResource(id = R.color.white_transparent200),
                            colorResource(id = R.color.black_transparent),
                        )
                    )
                )
                .fillMaxWidth()
        ) {
            CategoryItem(
                category = article.category,
                onClick = { /*TODO*/ },
                backgroundColor = Color.White,
                textColor = colorResource(
                    id = R.color.primary
                ),
                modifier = Modifier
                    .padding(start = Constants.Width.Small, top = Constants.Width.SmallX)
                    .height(Constants.Width.SmallX)

            )
            Text(
                modifier = Modifier
                    .padding(start = Constants.Width.Small, top = Constants.Width.XSmall),
                text = refactoringText(article.title, 100),
                color = Color.White,
                fontWeight = FontWeight.W700
            )

        }


    }


}


