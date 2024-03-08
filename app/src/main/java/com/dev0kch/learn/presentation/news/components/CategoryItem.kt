package com.dev0kch.learn.presentation.news.components


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import com.dev0kch.learn.R
import com.dev0kch.learn.domain.model.Category
import com.dev0kch.learn.utils.Constants

@Composable
fun CategoryItem(
    category: Category,
    onClick: () -> Unit,
    backgroundColor: Color = colorResource(id = R.color.primary),
    textColor: Color = Color.White,
    modifier : Modifier =Modifier
) {
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier = Modifier
            .clip(
                RoundedCornerShape(Constants.RoundedCorner.ImageRoundedCorner)
            )

            .padding(end = Constants.Padding.MediumPadding).then(modifier),
        onClick = onClick
    ) {
        Text(
            text = category.name,
            color = textColor,
            fontWeight = FontWeight.W500,
            fontSize = Constants.Text.H3

        )
    }
}
