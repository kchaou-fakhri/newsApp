package com.dev0kch.learn.domain.repository

import com.dev0kch.learn.data.model.dto.ResponseDto
import retrofit2.http.Path

interface NewsApiRepository {

    suspend fun getEverythings(
        query: String,
        date: String,
        sortBy: String,
        apiKey: String
    ) : ResponseDto
}