package com.dev0kch.learn.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dev0kch.learn.domain.model.Article

class SharedViewModel : ViewModel() {
    var article by mutableStateOf<Article?>(null)
        private set

    fun addArticle(newArticle : Article){
        article = newArticle
    }

}