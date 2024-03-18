package com.dev0kch.learn.data.repository

import com.dev0kch.learn.MainCoroutineRule
import com.dev0kch.learn.data.api.NewsApi
import com.dev0kch.learn.data.model.dto.ResponseDto
import com.dev0kch.learn.mock.Mocked
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@ExperimentalCoroutinesApi
class NewsTestApi {

    private lateinit var mockServer: MockWebServer
    private lateinit var api: NewsApi

    @get:Rule
    private val mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        mockServer = MockWebServer()
        api = Retrofit
            .Builder()
            .baseUrl(mockServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)
    }

    @After
    fun after() {
        mockServer.shutdown()
    }

    @Test
    fun `Should return a data with success`(): Unit = runBlocking {
        val dto = ResponseDto(
            Mocked.mockedArticles,
            "OK", Mocked.mockedArticles.size
        )
        val gson: Gson = GsonBuilder().create()
        val json = gson.toJson(dto)!!//Conver the object into json string using GSON
        val res = MockResponse()//Make a fake response for our server call
        res.setBody(json)//set the body of the fake response as the json string you are expecting as a response
        mockServer.enqueue(res)//add it in the server response queue

        val data = api.getAllNews("", "", "", "")//make the call to our fake server(as we are using fake base url)
        mockServer.takeRequest()//let the server take the request

        assertThat(data.articles.size).isEqualTo(Mocked.mockedArticles.size)


    }
}
