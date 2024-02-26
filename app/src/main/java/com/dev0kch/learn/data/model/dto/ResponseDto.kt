package com.dev0kch.learn.data.model.dto

data class ResponseDto(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)