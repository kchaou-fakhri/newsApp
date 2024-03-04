package com.dev0kch.learn.domain.usecase

import com.dev0kch.learn.common.Resource
import com.dev0kch.learn.configuration.WSConfiguration
import com.dev0kch.learn.data.model.dto.toArticle
import com.dev0kch.learn.data.repository.remote.NewsRepositoryImpl
import com.dev0kch.learn.domain.model.Article
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import java.io.IOException

import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepositoryImpl
) {
    operator fun invoke(): Flow<Resource<List<Article>>> = flow {
        try {
            emit(Resource.Loading<List<Article>>())
            val news = repository.getEverythings(
                "tesla",
                "2024-01-26",
                "publishedAt",
                WSConfiguration.API_KEY
            ).articles.map { article ->
                article.toArticle()
            }
            emit(Resource.Success<List<Article>>(news))
        } catch (e: retrofit2.HttpException) {
            emit(Resource.Error(e.message()))
        } catch (e: IOException) {
            emit(Resource.Error(e.message ?: "Error"))

        }
    }
}