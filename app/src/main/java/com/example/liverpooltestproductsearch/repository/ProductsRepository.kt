package com.example.liverpooltestproductsearch.repository
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.liverpooltestproductsearch.data.network.ApiLiverpool
import com.example.liverpooltestproductsearch.data.ProductsDataSource
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val apiLiverpool: ApiLiverpool) {


    fun getProducts(searchString: String, minSortPrice: Int) = Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = 1),
        pagingSourceFactory = {
            ProductsDataSource(apiLiverpool, searchString, minSortPrice)
        }
    ).flow

    fun getProductsSortPrice(searchString: String, minSortPrice: Int) = Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = 1),
        pagingSourceFactory = {
            ProductsDataSource(apiLiverpool, searchString, minSortPrice)
        }
    ).flow
}