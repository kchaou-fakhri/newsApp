package com.dev0kch.learn.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dev0kch.learn.common.Resource
import com.dev0kch.learn.domain.model.Article
import com.dev0kch.learn.domain.usecase.GetNewsUseCase
import com.dev0kch.learn.presentation.news.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListNewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase,

) : ViewModel() {

    private val _state = mutableStateOf(NewsState())
    val state: State<NewsState> = _state

    init {
        getListNews()
    }

    private fun getListNews() {
        getNewsUseCase().onEach { result ->

            Log.println(Log.ASSERT, "DTET", result.toString())
            when (result) {
                is Resource.Loading -> {
                    _state.value = NewsState(loading = true)
                }

                is Resource.Success -> {
                    _state.value = NewsState(data = result.data ?: emptyList<Article>())
                }

                is Resource.Error -> {
                    _state.value = NewsState(error = result.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }
}