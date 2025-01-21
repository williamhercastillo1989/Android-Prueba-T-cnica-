package com.example.liverpooltestproductsearch.data.network


import com.example.liverpooltestproductsearch.data.response.ResponsePlpResult
import com.example.liverpooltestproductsearch.utils.Constants.ENDPOINT
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiLiverpool {

    @GET(ENDPOINT)
    suspend fun getPaginationProduct(
        @Query("search-string") search: String,
        @Query("page-number") page: Int,
    ): ResponsePlpResult


    @GET(ENDPOINT)
    suspend fun getPaginationProductSortPrice(
        @Query("search-string") search: String,
        @Query("page-number") page: Int,
        @Query("minSortPrice") minSortPrice: Int,
    ): ResponsePlpResult

}