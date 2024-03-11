package com.dev0kch.learn.domain.model

import android.os.Parcelable
import com.dev0kch.learn.data.model.dto.Source
import com.dev0kch.learn.utils.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val author: String?,
    val content: String?,
    val description: String?,
    val createdAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val image: String?,
    val category: Category = Constants.categories[0]
) : Parcelable {
}