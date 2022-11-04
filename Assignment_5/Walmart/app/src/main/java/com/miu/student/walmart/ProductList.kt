package com.miu.student.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_product_list.*

class ProductList : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        //get product list from intent
        var products = intent.getSerializableExtra("products") as ArrayList<Product>
        //display product list
        var adapter = ProductsAdapter(products)
        adapter.onItemClick ={
            var intent = Intent(this, ProductDetails::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
        //set layout manager
        productList.layoutManager = LinearLayoutManager(this)
        productList.adapter = adapter

    }
}