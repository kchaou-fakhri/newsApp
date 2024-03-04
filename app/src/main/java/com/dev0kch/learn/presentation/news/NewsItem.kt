package com.dev0kch.learn.presentation.news

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.dev0kch.learn.R
import com.dev0kch.learn.common.refactoringDate
import com.dev0kch.learn.common.refactoringText
import com.dev0kch.learn.domain.model.Article
import com.dev0kch.learn.utils.Constants
import com.dev0kch.learn.utils.fackArticle

@Composable
fun NewsItem(article: Article) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .height(Constants.NewsItemHeight)
            .padding(Constants.Padding.SmallPadding)
    ) {

        Column(
            modifier = Modifier
                .weight(1f)
                .height(Constants.NewsItemHeight)
        ) {
            AsyncImage(
                model = article,
                contentDescription = null,
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .border(
                        width = Constants.smallBorder,
                        color = Color.Transparent,
                        shape = RoundedCornerShape(
                            Constants.ImageRoundedCorner
                        )
                    )
                    .fillMaxSize()


            )
        }


        Column(
            modifier = Modifier
                .weight(2f)
                .height(Constants.NewsItemHeight)
        ) {
            Text(
                text = article.author ?: "Adam Smith",
                fontSize = Constants.Text.H5,
                color = colorResource(id = R.color.text_color)
            )

            Text(
                modifier = Modifier.padding(top = Constants.Padding.TextPadding),
                text = refactoringText(article.title, 60),
                fontSize = Constants.Text.H4,
                maxLines = 2,
                color = colorResource(id = R.color.text_color)
            )

            Text(
                modifier = Modifier.padding(top = Constants.Padding.SmallPadding),
                text = refactoringDate(article.createdAt),
                fontSize = Constants.Text.H5,
                maxLines = 2,
                color = Color.Gray
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .height(Constants.NewsItemHeight),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.End
        ) {
            Image(painter = painterResource(id = R.drawable.ic_bookmark), contentDescription = null)
        }
    }
}


@Preview
@Composable
fun NewsItemPreview() {
    NewsItem(fackArticle)
}

