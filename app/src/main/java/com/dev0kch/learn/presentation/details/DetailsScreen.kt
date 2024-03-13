package com.dev0kch.learn.presentation.details

import android.webkit.WebView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.viewinterop.AndroidView

import androidx.navigation.NavHostController
import com.dev0kch.learn.R
import com.dev0kch.learn.common.checkImage
import com.dev0kch.learn.common.refactoringDate
import com.dev0kch.learn.common.refactoringText
import com.dev0kch.learn.domain.model.Article
import com.dev0kch.learn.presentation.details.components.ArticleImage
import com.dev0kch.learn.presentation.viewmodel.SharedViewModel
import com.dev0kch.learn.utils.Constants

@Composable
fun DetailsScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val article = sharedViewModel.article
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
//        ArticleImage(imageUrl = checkImage(article?.image), category = article!!.category)
//        Text(
//            modifier = Modifier.padding(
//                top = Constants.Width.XSmall,
//                start = Constants.Width.Small,
//                end = Constants.Width.Small
//            ),
//            text = refactoringText(article.title, 200),
//            color = colorResource(id = R.color.text_color),
//            fontWeight = FontWeight.W500
//        )
//        Row(
//            modifier = Modifier
//                .padding(Constants.Width.Small),
//        ) {
//            Text(
//                text = article.author ?: stringResource(id = R.string.app_name),
//                fontSize = Constants.Text.H5,
//                color = colorResource(id = R.color.text_color),
//                fontWeight = FontWeight.W400
//
//            )
//
//            Text(
//                modifier = Modifier.padding(start = Constants.Padding.SmallPadding),
//                text = "• " + refactoringDate(article.createdAt),
//                fontSize = Constants.Text.H5,
//                maxLines = 2,
//                color = Color.Gray
//            )
//        }
//
//        Text(
//            modifier = Modifier
//                .padding(
//                    top = Constants.Width.XSmall,
//                    start = Constants.Width.Small,
//                    end = Constants.Width.Small
//                ),
//            text = article.description!!,
//            fontSize = Constants.Text.H5,
//            fontWeight = FontWeight.W400,
//            lineHeight = Constants.Text.H4,
//            color = colorResource(id = R.color.text_color),
//        )

        AndroidView(
            modifier = Modifier
                .fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    this.webViewClient = webViewClient
                }
            },
            update = { webView ->
                webView.loadUrl(article?.url!!)
            }
        )



    }
}
