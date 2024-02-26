package com.dev0kch.learn

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import com.dev0kch.learn.presentation.viewmodel.ListNewsViewModel
import com.dev0kch.learn.ui.theme.LearnTheme
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTheme {
                // A surface container using the 'background' color from the theme

                val newsViewModel : ListNewsViewModel = hiltViewModel()


                lifecycleScope.launchWhenCreated {
                    Log.d("DATA", "START")

                    newsViewModel.getListNews().collect{ articles ->

                        articles.forEach {article ->
                                Log.d("DATA", article.toString())

                        }

                    }

               }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}
