package com.dev0kch.learn.data.repository.remote

import android.util.Log
import com.dev0kch.learn.data.api.NewsApi
import com.dev0kch.learn.data.model.dto.ResponseDto
import com.dev0kch.learn.domain.repository.NewsApiRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApi: NewsApi
) : NewsApiRepository {


    override suspend fun getEverythings(
        query: String,
        date: String,
        sortBy: String,
        apiKey: String
    ): ResponseDto {
        Log.d("DATA", "DDDDD")
            var data = newsApi.getAllNews(query, date, sortBy, apiKey)
        Log.d("DATA", data.toString())

        return data
    }
}