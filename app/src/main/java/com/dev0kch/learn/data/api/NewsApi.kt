package com.dev0kch.learn.data.api

import com.dev0kch.learn.data.model.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("everything")
    suspend fun getAllNews(
        @Query("q") query: String,
        @Query("date") date: String,
        @Query("sortBy") sortBy: String,
        @Query("apiKey") apiKey: String,
        @Query("pageSize") pageSize: String? = "25",
        @Query("language") language: String? = "en"
    ): ResponseDto
}

