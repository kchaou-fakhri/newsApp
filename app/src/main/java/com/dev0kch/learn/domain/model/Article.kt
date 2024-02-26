package com.dev0kch.learn.domain.model

import com.dev0kch.learn.data.model.dto.Source

data class Article(
    val author: String,
    val content: String,
    val description: String,
    val createdAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val image: String
) {
}