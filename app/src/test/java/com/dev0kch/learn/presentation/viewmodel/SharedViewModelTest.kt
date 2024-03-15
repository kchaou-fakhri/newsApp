package com.dev0kch.learn.presentation.viewmodel

import com.dev0kch.learn.domain.model.Article
import com.google.common.truth.Truth.assertThat
import org.junit.Before

import org.junit.Test

class SharedViewModelTest {

    private lateinit var viewModel: SharedViewModel

    @Before
    fun setup() {
        viewModel = SharedViewModel()
    }

    @Test
    fun addArticle() {
        val article =  Article(
            author = "Author",
            content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duo Reges: constructio interrete. Cuius quidem, quoniam Stoicus fuit, sententia condemnata mihi videtur esse inanitas ista verborum. Quorum altera prosunt, nocent altera. Cum ageremus, inquit, vitae beatum et eundem supremum diem, scribebamus haec. Stoicos roga. Quid nunc honeste dicit? Quorum sine causa fieri nihil putandum est.",
            description = null,
            createdAt = null,
            source = null,
            title = null,
            url = null,
            image = null
        )
        viewModel.addArticle(
           article
        )

        val result = viewModel.article
            assertThat(result).isEqualTo(result)
    }


}