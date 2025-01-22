package com.ecommerce.model

data class Product(
    val title: String,
    val price: String,
    val url: String
)

//import android.content.res.Resources
//import android.net.Uri
//import com.ecommerce.R
//import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.reflect.TypeToken
//import java.io.BufferedReader
//import java.util.*
//
///**
// * A product entry in the list of products.
// */
//class ProductEntry(
//    val title: String, dynamicUrl: String, val url: String, val price: String, val description: String) {
//    val dynamicUrl: Uri = Uri.parse(dynamicUrl)
//
//    companion object {
//        /**
//         * Loads a raw JSON at R.raw.products and converts it into a list of ProductEntry objects
//         */
//        fun initProductEntryList(resources: Resources): List<ProductEntry> {
//            val inputStream = resources.openRawResource(R.raw.products)
//            val jsonProductsString = inputStream.bufferedReader().use(BufferedReader::readText)
//            val gson = Gson()
//            val productListType = object : TypeToken<ArrayList<ProductEntry>>() {}.type
//            return gson.fromJson<List<ProductEntry>>(jsonProductsString, productListType)
//        }
//    }
//}