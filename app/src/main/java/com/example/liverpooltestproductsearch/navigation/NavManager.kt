package com.example.liverpooltestproductsearch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.liverpooltestproductsearch.ui.views.ProductView
import com.example.liverpooltestproductsearch.viewmodel.ProductsViewModel

@Composable
fun NavManager(viewModel: ProductsViewModel){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "ProductSearch"){
        composable("ProductSearch"){
            ProductView(viewModel)
        }
    }
}