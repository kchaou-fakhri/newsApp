package com.dev0kch.learn.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.dev0kch.learn.configuration.WSConfiguration
import com.dev0kch.learn.data.model.dto.toArticle
import com.dev0kch.learn.data.repository.remote.NewsRepositoryImpl
import com.dev0kch.learn.domain.model.Article
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class ListNewsViewModel @Inject constructor(
    private val repositoryImpl: NewsRepositoryImpl
) : ViewModel() {

    init {
        getListNews()
    }
    fun getListNews(): Flow<List<Article>> = flow<List<Article>> {
        emit(
            repositoryImpl.getEverythings(
                "tesla",
                "2024-01-26",
                "publishedAt",
                WSConfiguration.API_KEY
            ).articles.map { article ->

                article.toArticle() }
        )
    }
}