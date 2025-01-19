package com.ecommerce.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.R
import com.ecommerce.model.Product
import com.ecommerce.viewModel.ProductsViewModel

class ProductsView : AppCompatActivity()
{
    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView:RecyclerView
    private val productsViewModel:ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(R.layout.list_products)

        // Inicialize o Toolbar
        toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolbar)

        // Configurações opcionais, como título ou ações
//        supportActionBar?.apply {
//            setDisplayHomeAsUpEnabled(true) // Habilita o botão de navegação (seta para trás)
//            setHomeAsUpIndicator(R.drawable.menu) // Define o ícone do menu
//            title = getString(R.string.app_name) // Define o título da Toolbar
//        }

        // Exemplo de lista de produtos
        val products = listOf(
            Product(title = "Product 1", price = "$10.00", url = "https://www.kapwing.com/studio/editor"),
            Product(title = "Product 2", price = "$20.00", url = "https%3A%2F%2Fpreview.redd.it%2Fi-keep-seeing-this-angry-cat-meme-does-anyone-know-what-v0-n9p8aheg9jw91.jpg%3Fwidth%3D1080%26crop%3Dsmart%26auto%3Dwebp%26s%3Daf0ff55ee92c8479c148d47e34d285633b98f76b"),
            Product(title = "Product 3", price = "$30.00", url = "https://jp.pinterest.com/pin/649081365075452682/"),
            Product(title = "Product 4", price = "$40.00", url = "https://jp.pinterest.com/pin/649081365075452682/")
        )

//        val products = listOf(
//            Product(title = "Product 1", price = "$10.00", url = "https://via.placeholder.com/150"),
//            Product(title = "Product 2", price = "$20.00", url = "https://via.placeholder.com/150"),
//            Product(title = "Product 3", price = "$30.00", url = "https://via.placeholder.com/150")
//        )

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Exemplo de grid com 2 colunas
      //  recyclerView.adapter = ProductCardRecyclerViewAdapter(products)

        productsViewModel.products.observe(this, Observer { products ->
            recyclerView.adapter = ProductCardRecyclerViewAdapter(products)
        })

    }

    // Infla o menu na Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu) // Substitua pelo nome correto do arquivo XML do menu
        return true
    }

    // Trata os cliques nos itens do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search -> {
                // Ação para o item de pesquisa
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.filter -> {
                // Ação para o item de filtro
                Toast.makeText(this, "Filter clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}