package com.example.liverpooltestproductsearch.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.liverpooltestproductsearch.R
import com.example.liverpooltestproductsearch.componets.LiverpoolSearchBar
import com.example.liverpooltestproductsearch.componets.LiverpoolTopBar
import com.example.liverpooltestproductsearch.componets.Loader
import com.example.liverpooltestproductsearch.componets.ProductList
import com.example.liverpooltestproductsearch.componets.SearchState
import com.example.liverpooltestproductsearch.componets.rememberSearchState
import com.example.liverpooltestproductsearch.viewmodel.ProductsViewModel

@Composable
fun ProductView(
    viewModel: ProductsViewModel,
    state: SearchState = rememberSearchState()
) {
    Scaffold(topBar = {
        LiverpoolTopBar(title =  stringResource(R.string.label_top_bar), onClickBackButton = {}, state)
    }, containerColor = Color.White) {
        ContentProductView(it, state, viewModel)
    }
}


@Composable
fun ContentProductView(
    pad: PaddingValues,
    state: SearchState,
    viewModel: ProductsViewModel
) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(pad)
    ) {
        LiverpoolSearchBar(
            query = state.query,
            onQueryChange = { state.query = it },
            searchFocused = state.focused,
            onSearchFocusChange = { state.focused = it },
            onClearQuery = { state.query = TextFieldValue("") },
            searching = state.searching,
            minSortPrice = state.minSortPrice,
            viewModel
        )
        HorizontalDivider(thickness = 2.dp)



        LaunchedEffect(Unit) {
            viewModel.getProducts(state.query.text, state.minSortPrice)
        }



        LaunchedEffect(state.minSortPrice) {
            state.searching = true
            if(!state.query.text.isNullOrEmpty()){
                viewModel.getProductsSortPrice(state.query.text, state.minSortPrice)
            }
            state.searching = false
        }

        val productsPage = viewModel.productPage.collectAsLazyPagingItems()

        when {
            //Carga inicial
            productsPage.loadState.refresh is LoadState.Loading && productsPage.itemCount == 0 -> {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    Loader()
                }
            }

            //Estado vacio
            productsPage.loadState.refresh is LoadState.NotLoading && productsPage.itemCount == 0 -> {

                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = stringResource(R.string.label_empy_response))
                }

            }

            productsPage.loadState.hasError -> {
                Box(
                    Modifier
                        .fillMaxSize()
                        .background(Color.Red),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = stringResource(R.string.label_error_response))
                }
            }

            else -> {
                ProductList(productsPage)

                if (productsPage.loadState.append is LoadState.Loading) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Loader()
                    }
                }
            }

        }
    }

}