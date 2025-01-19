package com.ecommerce.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ecommerce.model.Product

class ProductsViewModel:ViewModel()
{
    private val _products = MutableLiveData<List<Product>>()
    val products:LiveData<List<Product>> get() = _products

    init {
        loadProducts()
    }

    private fun loadProducts()
    {
        val productList = listOf(
            Product(title = "Product 1", price = "$10.00", url = "https://www.kapwing.com/studio/editor"),
            Product(title = "Product 2", price = "$20.00", url = "https%3A%2F%2Fpreview.redd.it%2Fi-keep-seeing-this-angry-cat-meme-does-anyone-know-what-v0-n9p8aheg9jw91.jpg%3Fwidth%3D1080%26crop%3Dsmart%26auto%3Dwebp%26s%3Daf0ff55ee92c8479c148d47e34d285633b98f76b"),
            Product(title = "Product 3", price = "$30.00", url = "https://jp.pinterest.com/pin/649081365075452682/"),
            Product(title = "Product 4", price = "$40.00", url = "https://jp.pinterest.com/pin/649081365075452682/")
        )

        _products.value = productList
    }
}