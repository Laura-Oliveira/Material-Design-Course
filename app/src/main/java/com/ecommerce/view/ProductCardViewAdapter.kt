package com.ecommerce.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecommerce.R
import com.ecommerce.model.Product

class ProductCardRecyclerViewAdapter(private val productList: List<Product>) : RecyclerView.Adapter<ProductCardViewHolder>()
{

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductCardViewHolder {
        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_card, parent, false)
        return ProductCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: ProductCardViewHolder, position: Int) {
        if (position < productList.size) {
            val product = productList[position]
            holder.productTitle.text = product.title
            holder.productPrice.text = product.price

            // Use Glide to load the product image
            Glide.with(holder.productImage.context)
                //.load(product.url)
                .load(R.drawable.ic_launcher_paid_foreground)
                .placeholder(R.drawable.logo)
                .into(holder.productImage)

          //  ImageRequester.setImageFromUrl(holder.productImage, product.url)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}

class ProductCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val productImage: ImageView = itemView.findViewById(R.id.card_view_product_image)
    val productTitle: TextView = itemView.findViewById(R.id.card_view_product_title)
    val productPrice: TextView = itemView.findViewById(R.id.card_view_product_price)
}