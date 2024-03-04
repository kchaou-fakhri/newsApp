package com.dev0kch.learn.presentation.news

import com.dev0kch.learn.domain.model.Article

data class NewsState(
    var loading: Boolean = false,
    var error: String = "",
    var data: List<Article> = emptyList()
)
