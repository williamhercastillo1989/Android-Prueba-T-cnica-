package com.example.liverpooltestproductsearch.data.response

import com.example.liverpooltestproductsearch.model.ProductModel

data class ResponsePlpResult(val status: Status,
                             val pageType: String,
                             val plpResults: PlpResults
)


data class Status(
    val status: String,
    val statusCode: Long,
)

data class PlpResults(
    val label: String,
    val plpState: PlpState,
    val sortOptions: List<SortOption>,
    val refinementGroups: List<RefinementGroup>,
    val records: List<ProductModel>,
    val navigation: Navigation,
    val customUrlParam: Map<String, Any>,
    val metaData: Map<String, Any>,
)

data class PlpState(
    val categoryId: String,
    val currentSortOption: String,
    val currentFilters: String,
    val firstRecNum: Long,
    val lastRecNum: Long,
    val recsPerPage: Long,
    val totalNumRecs: Long,
    val originalSearchTerm: String,
    val plpSellerName: String,
)

data class SortOption(
    val sortBy: String,
    val label: String,
)

data class RefinementGroup(
    val name: String,
    val refinement: List<Refinement>,
    val multiSelect: Boolean,
    val dimensionName: String,
)

data class Refinement(
    val count: Long,
    val label: String,
    val refinementId: String,
    val selected: Boolean,
    val type: String,
    val searchName: String?,
    val high: String?,
    val low: String?,
    val colorHex: String?,
)

data class Navigation(
    val ancester: List<Ancester>,
    val current: List<Current>,
    val childs: List<Any?>,
)

data class Ancester(
    val label: String,
    val categoryId: String,
)

data class Current(
    val label: String,
    val categoryId: String,
)