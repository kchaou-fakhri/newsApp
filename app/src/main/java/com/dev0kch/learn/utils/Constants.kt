package com.dev0kch.learn.utils

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev0kch.learn.domain.model.Category

object Constants {


    object RoundedCorner {
        val ImageRoundedCorner = 7.dp
    }

    object Width {

        val XXSmall = 5.dp
        val XSmall = 10.dp
        val Small = 20.dp
        val SmallX = 30.dp
        val SmallXX = 40.dp
        val SmallXXX = 50.dp

        val Medium = 60.dp
        val MediumX = 70.dp
        val MediumXX = 80.dp
        val MediumXXX = 90.dp

        val Large = 100.dp
        val LargeX = 110.dp
        val LargeXX = 120.dp
        val LargeXXX = 130.dp

        val X = 140.dp
        val XX = 150.dp
        val XXX = 160.dp
        val XXXX = 170.dp

        val XLarge = 170.dp
        val XXLarge = 180.dp
        val XXXLarge = 190.dp
        val X4Large = 200.dp
        val X5Large = 210.dp
        val X6Large = 220.dp
        val X7Large = 230.dp
        val X8Large = 240.dp
        val X10Large = 250.dp
        val X11Large = 260.dp
        val X12Large = 270.dp
        val X13Large = 280.dp
        val X14Large = 290.dp
        val X15Large = 300.dp
        val X16Large = 310.dp
        val X17Large = 320.dp
        val X18Large = 330.dp
        val X19Large = 340.dp
        val X30Large = 350.dp


    }

    object Padding {
        val SmallPadding = 5.dp
        val MediumPadding = 10.dp
        val TextPadding = 3.dp
    }

    object Text {
        val H3 = 15.sp
        val H4 = 13.sp
        val H5 = 10.sp
        val LineHeight = 5.sp
    }

    object AlternativeData {
        val NewsURL =
            "https://images.unsplash.com/photo-1504711434969-e33886168f5c?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
    }


    val categories = listOf<Category>(
        Category("general", "All"),
        Category("business", "Business"),
        Category("entertainment", "Entertainment"),
        Category("health", "Health"),
        Category("science", "Science"),
        Category("sports", "Sports"),
        Category("technology", "Technology"),
    )

    val unAcceptedImageType = listOf<String>("sl=1", "webp")


    object ContentDescription {
        object NewsItem {
            val Image = "News Image"
            val BookMarkIcon = "Book Mark Icon"
        }
    }

}