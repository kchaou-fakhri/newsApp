package com.dev0kch.learn.data.model.dto

import com.dev0kch.learn.domain.model.Article

data class ArticleDto(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
)

fun ArticleDto.toArticle() : Article {
    return Article(
        author,
        content,
        description,
        publishedAt,
        source,
        title,
        url,
        urlToImage
    )
}