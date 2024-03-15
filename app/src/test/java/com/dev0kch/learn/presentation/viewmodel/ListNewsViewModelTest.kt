package com.dev0kch.learn.presentation.viewmodel

import android.arch.core.executor.testing.InstantTaskExecutorRule
import com.dev0kch.learn.domain.usecase.GetNewsUseCase
import com.dev0kch.learn.repository.MockedNewsApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.setMain
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



    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined) // Set main dispatcher to unconfined for testing
    }

    private lateinit var viewModel: ListNewsViewModel

    @Before
    fun initViewModel() {
        viewModel = ListNewsViewModel(GetNewsUseCase(MockedNewsApiRepository()))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun validateGetState() = runBlocking {
        val result = viewModel.state.value
        assertThat(result).isNotNull()
    }
}