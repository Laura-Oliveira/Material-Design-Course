package com.ecommerce.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
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
    private lateinit var expandedMenu: LinearLayoutCompat
    private lateinit var btnExit:Button
    private lateinit var recyclerView:RecyclerView
    private val productsViewModel:ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.list_products)

        btnExit = findViewById(R.id.btn_menu_exit)
        expandedMenu = findViewById(R.id.app_bar_expanded)

        // Inicialize o Toolbar
        toolbar = findViewById(R.id.app_bar)
        setSupportActionBar(toolbar)

        // Configurações opcionais, como título ou ações
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true) // Habilita o botão de navegação (seta para trás)
            setHomeAsUpIndicator(R.drawable.menu) // Define o ícone do menu
            title = getString(R.string.app_name) // Define o título da Toolbar
        }

        // Adiciona o clique no botão de navegação
        toolbar.setNavigationOnClickListener {
            toggleExpandedMenu()
            //showPopupMenu(it)
        }

        btnExit.setOnClickListener {
            expandedMenu.visibility = View.GONE
        }

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // Exemplo de grid com 2 colunas

        // Set cut corner background for API 23+
     //   recyclerView.background =  AppCompatResources.getDrawable(this,R.drawable.product_grid_background_shape)

        productsViewModel.products.observe(this, Observer { products ->
            recyclerView.adapter = ProductCardRecyclerViewAdapter(products)
        })
    }

    // Infla o menu na Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean
    {
        menuInflater.inflate(R.menu.toolbar_menu, menu) // Substitua pelo nome correto do arquivo XML do menu
        return true
    }

    // Alterna a visibilidade do menu expandido com animação
//    private fun toggleExpandedMenu() {
//        if (expandedMenu.visibility == View.GONE) {
//            // Mostra o menu
//            expandedMenu.visibility = View.VISIBLE
//            val slideIn = ObjectAnimator.ofFloat(expandedMenu, "translationY", expandedMenu.height.toFloat(), 0f)
//            slideIn.duration = 300
//            slideIn.start()
//
//            // Troca o ícone para o de cancelamento
//            btnExit.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.baseline_cancel_24, 0)
//        } else {
//            // Esconde o menu
//            val slideOut = ObjectAnimator.ofFloat(expandedMenu, "translationY", 0f, expandedMenu.height.toFloat())
//            slideOut.duration = 300
//            slideOut.addListener(object : AnimatorListenerAdapter() {
//                override fun onAnimationEnd(animation: Animator) {
//                    expandedMenu.visibility = View.GONE
//                }
//            })
//            slideOut.start()
//
//            // Troca o ícone para o de menu
//            btnExit.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.branded_menu, 0)
//        }
//    }


    // Animação para mostrar/ocultar o menu expandido
    private fun toggleExpandedMenu() {
        if (expandedMenu.visibility == View.GONE) {
            expandedMenu.visibility = View.VISIBLE
            val slideIn = ObjectAnimator.ofFloat(expandedMenu, "translationY", expandedMenu.height.toFloat(), 0f)
            slideIn.duration = 300
            slideIn.start()
        } else {
            val slideOut = ObjectAnimator.ofFloat(expandedMenu, "translationY", 0f, expandedMenu.height.toFloat())
            slideOut.duration = 300
            slideOut.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    expandedMenu.visibility = View.GONE
                }
            })
            slideOut.start()
        }
    }

    // Trata os cliques nos itens do menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        return when (item.itemId)
        {
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