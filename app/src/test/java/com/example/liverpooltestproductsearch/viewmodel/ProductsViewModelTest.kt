package com.example.liverpooltestproductsearch.viewmodel

import androidx.paging.PagingData
import com.example.liverpooltestproductsearch.model.ProductModel
import com.example.liverpooltestproductsearch.repository.ProductsRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations


class ProductsViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @Mock
    lateinit var productsRepository: ProductsRepository
    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun `test getProducts`() = runTest {
        val searchString = "product"
        val minSortPrice = 100

        val product = ProductModel.Builder()
            .productId("12345")
            .skuRepositoryId("sku123")
            .productDisplayName("Example Product")
            .productType("Electronics")
            .productRatingCount(100)
            .productAvgRating(4.5)
            .promotionalGiftMessage("Free gift included!")
            .listPrice(299.99)
            .minimumListPrice(279.99)
            .maximumListPrice(319.99)
            .promoPrice(249.99)
            .minimumPromoPrice(239.99)
            .maximumPromoPrice(259.99)
            .build()

        val product2 = ProductModel.Builder()
            .productId("12345")
            .skuRepositoryId("sku123")
            .productDisplayName("Example Product")
            .productType("Electronics")
            .productRatingCount(100)
            .productAvgRating(4.5)
            .promotionalGiftMessage("Free gift included!")
            .listPrice(299.99)
            .minimumListPrice(279.99)
            .maximumListPrice(319.99)
            .promoPrice(249.99)
            .minimumPromoPrice(239.99)
            .maximumPromoPrice(259.99)
            .build()

        val mockPagingData: PagingData<ProductModel> = PagingData.from(listOf(product,product2))

        val mockFlow: Flow<PagingData<ProductModel>> = flowOf(mockPagingData)

        // Mock del método getProducts
        `when`(productsRepository.getProducts(searchString, minSortPrice)).thenReturn(mockFlow)

        // Recoge los elementos emitidos por el flujo
        val result = mutableListOf<PagingData<ProductModel>>()
        productsRepository.getProducts(searchString, minSortPrice).collect { pagingData ->
            result.add(pagingData)
        }

        // Verifica que el flujo emitido sea el esperado
        assertEquals(1, result.size) // Verifica que se haya emitido un elemento
        // O verifica los datos específicos del resultado según sea necesario
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}