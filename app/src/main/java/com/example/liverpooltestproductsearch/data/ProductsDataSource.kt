package com.example.liverpooltestproductsearch.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.liverpooltestproductsearch.data.network.ApiLiverpool
import com.example.liverpooltestproductsearch.data.response.ResponsePlpResult
import com.example.liverpooltestproductsearch.model.ProductModel
import com.example.liverpooltestproductsearch.utils.Constants.LIVERPOOL_STARTING_OFFSET

class ProductsDataSource(
    private val apiLiverpool: ApiLiverpool,
    private val searchString: String,
    private val minSortPrice: Int?
) : PagingSource<Int, ProductModel>() {

    override fun getRefreshKey(state: PagingState<Int, ProductModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductModel> {
        return try {
            val nextPageNumber = params.key ?: LIVERPOOL_STARTING_OFFSET
            val response: ResponsePlpResult = if (minSortPrice == -1) {
                apiLiverpool.getPaginationProduct(searchString, nextPageNumber)
            } else {
                apiLiverpool.getPaginationProductSortPrice(
                    searchString,
                    nextPageNumber,
                    minSortPrice!!
                )
            }
            LoadResult.Page(
                data = response.plpResults.records,
                prevKey = null,
                nextKey = if (response.plpResults.records.isNotEmpty()) nextPageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}