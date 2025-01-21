package com.example.liverpooltestproductsearch.ui.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.liverpooltestproductsearch.navigation.NavManager
import com.example.liverpooltestproductsearch.ui.theme.LiverpoolTestProductSearchTheme
import com.example.liverpooltestproductsearch.viewmodel.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel : ProductsViewModel by viewModels()
        setContent {
            LiverpoolTestProductSearchTheme {
                NavManager(viewModel)
            }
        }
    }
}
