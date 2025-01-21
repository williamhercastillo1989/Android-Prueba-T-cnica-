package com.example.liverpooltestproductsearch.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.liverpooltestproductsearch.model.ProductModel
import com.example.liverpooltestproductsearch.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(private val repository: ProductsRepository) : ViewModel() {

    var productPage: Flow<PagingData<ProductModel>> = emptyFlow()

    fun getProducts(searchString: String, minSortPrice: Int): Flow<PagingData<ProductModel>> {
        val newResult: Flow<PagingData<ProductModel>> =
            repository.getProducts(searchString, minSortPrice).cachedIn(viewModelScope)
        productPage = newResult
        return newResult
    }

    fun getProductsSortPrice(searchString: String , minSortPrice: Int): Flow<PagingData<ProductModel>> {
        val newResult: Flow<PagingData<ProductModel>> =
            repository.getProductsSortPrice(searchString, minSortPrice).cachedIn(viewModelScope)
        productPage = newResult
        return newResult
    }
}