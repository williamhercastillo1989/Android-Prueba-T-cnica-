package com.example.liverpooltestproductsearch.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.paging.compose.LazyPagingItems
import coil.compose.rememberImagePainter
import com.example.liverpooltestproductsearch.model.ProductModel


@Composable
fun ProductList(
    productList: LazyPagingItems<ProductModel>
) {
    LazyColumn(Modifier.padding(top = 50.dp)) {
        items(productList.itemCount) { index ->
            val item = productList[index]
            if (item != null) {
                ProductItem(product = item)
            }
        }
    }
}

@Composable
fun ProductItem(product: ProductModel) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White, //Card background color
            contentColor = Color.Black,
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
    ) {

        Row {
            ProductImage(product.lgImage)
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = product.productDisplayName, style = typography.titleMedium)
                Text(
                    text = "$${product.minimumPromoPrice}",
                    style = typography.titleSmall,
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "$${product.minimumListPrice}",
                    style = typography.titleMedium,
                    color = Color.Red
                )

                Row {
                    if(!product.variantsColor.isNullOrEmpty()) {
                        ColorsProduct(product)
                    }
                }
            }
        }
    }
}

@Composable
fun ColorsProduct(product: ProductModel) {

    LazyRow {
        items(product.variantsColor.size) { index ->
            val item = product.variantsColor[index]
            if(item.colorHex.isNotBlank()) {
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(30.dp)
                        .aspectRatio(1f)
                        .background(Color(item.colorHex.toColorInt()), shape = CircleShape)
                )
            }
        }
    }

}

@Composable
fun ProductImage(image: String) {

    val imageProduct = rememberImagePainter(data = image)
    Image(
        painter = imageProduct,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}
