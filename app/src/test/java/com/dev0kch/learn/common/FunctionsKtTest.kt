package com.dev0kch.learn.common

import com.dev0kch.learn.utils.fackUrl
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class FunctionsKtTest {

    @Test
    fun `it should refactoring Text`() {
        val result = refactoringText("hello", 2)
        assertThat(result).isEqualTo("he...")

    }

    @Test
    fun `it should refactoring Date`() {
        val result = refactoringDate("2024-03-14T10:54:27Z")
        assertThat(result).contains("Mar")
        assertThat(result).contains("Thu")
    }

    @Test
    fun `it should return a local url when the url image is empty`() {
        val result = checkImage("")
        assertThat(result).isEqualTo(fackUrl)
    }

    @Test
    fun `it should return a local url when the url image contain invalid format`() {
        val result = checkImage("url.webp")
        assertThat(result).isEqualTo(fackUrl)
    }
}