package com.dev0kch.learn.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.dev0kch.learn.common.refactoringDate
import com.dev0kch.learn.common.refactoringText
import com.dev0kch.learn.data.model.dto.toArticle
import com.dev0kch.learn.domain.model.Category
import com.dev0kch.learn.mock.Mocked
import com.dev0kch.learn.presentation.news.components.CategoryItem
import com.dev0kch.learn.presentation.news.components.NewsItem
import com.dev0kch.learn.utils.Constants
import org.junit.Rule
import org.junit.Test


class NewsScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var mockedArticle = Mocked.mockedArticles[0].toArticle()

    @Test
    fun verifyNewsItem() {

        composeTestRule.setContent {
            NewsItem(article = mockedArticle)
        }

        composeTestRule.onNodeWithContentDescription(Constants.ContentDescription.NewsItem.Image).assertIsDisplayed()
        composeTestRule.onNodeWithText(mockedArticle.author!!).assertIsDisplayed()
        composeTestRule.onNodeWithText(refactoringText(mockedArticle.title, 60)).assertIsDisplayed()
        composeTestRule.onNodeWithText(refactoringDate( mockedArticle.createdAt)).assertIsDisplayed() // Assuming this is the formatted date
        composeTestRule.onNodeWithContentDescription(Constants.ContentDescription.NewsItem.BookMarkIcon).assertIsDisplayed()

    }

    @Test
    fun categoryItem_DisplayedCorrectly() {
        // Given
        val category = Category("tech","Technology")

        // When
        composeTestRule.setContent {
            CategoryItem(category = category, onClick = {})
        }

        // Then
        composeTestRule.onNodeWithText("Technology").assertExists()
    }

    @Test
    fun categoryItem_Click() {
        // Given
        var clicked = false
        val category = Category("tech","Technology")

        // When
        composeTestRule.setContent {
            Box { // Using Box to have a clickable area
                CategoryItem(category = category, onClick = { clicked = true })
            }
        }

        // Then
        composeTestRule.onNodeWithText("Technology").assertExists().performClick()
        assert(clicked)
    }


}