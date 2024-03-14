package com.dev0kch.learn.utils


import com.google.common.truth.Truth.assertThat
import org.junit.Test

class RegistrationUtilTest {

    @Test
    fun `it should empty username return false`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `it should validate the username and repeated password`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "pole",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `it should validate username and refused repeated password`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "pole",
            "123",
            "1234"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `it should return false when password contains less then 2 digital`() {
        val result = RegistrationUtil.validateRegistrationInput(
            "pole",
            "1aaa",
            "1aaa"
        )
        assertThat(result).isFalse()
    }
}