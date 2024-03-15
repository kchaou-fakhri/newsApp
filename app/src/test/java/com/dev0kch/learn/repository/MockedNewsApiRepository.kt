package com.dev0kch.learn.repository

import com.dev0kch.learn.data.model.dto.ResponseDto
import com.dev0kch.learn.domain.repository.NewsApiRepository
import com.dev0kch.learn.mock.Mocked

class MockedNewsApiRepository : NewsApiRepository {

    private val mockedArticles = Mocked.mockedArticles

    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value : Boolean){
        shouldReturnNetworkError = value
    }

    override suspend fun getEverythings(
        query: String,
        date: String,
        sortBy: String,
        apiKey: String
    ): ResponseDto {
       return  ResponseDto(mockedArticles, "OK", mockedArticles.size)
    }

}