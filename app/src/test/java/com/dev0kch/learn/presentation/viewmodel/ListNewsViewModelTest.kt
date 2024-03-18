package com.dev0kch.learn.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dev0kch.learn.MainCoroutineRule
import com.dev0kch.learn.domain.usecase.GetNewsUseCase
import com.dev0kch.learn.data.repository.MockedNewsApiRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule

import org.junit.Test

@ExperimentalCoroutinesApi
class ListNewsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    /** @Important
     *  We can use mainCoroutine class or implement the configuration inside the @Before Function
     **/
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

//    @Before
//    fun setup() {
//        Dispatchers.setMain(Dispatchers.Unconfined) // Set main dispatcher to unconfined for testing
//    }

    private lateinit var viewModel: ListNewsViewModel

    @Before
    fun initViewModel() {
        viewModel = ListNewsViewModel(GetNewsUseCase(MockedNewsApiRepository()))
    }

    @Test
    fun validateGetState() = runBlocking {
        val result = viewModel.state.value
        assertThat(result).isNotNull()
    }
}