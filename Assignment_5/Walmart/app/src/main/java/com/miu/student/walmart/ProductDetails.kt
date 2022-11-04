package com.miu.student.walmart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        //get product from intent
        //display product details
        var product = intent.getSerializableExtra("product") as Product
        //display product details
        productTitle.text = product.Title
        productColor.text = product.color
        productNumber.text = product.itemid
        productImage.setImageResource(product.image)
        productDescription.text = product.desc
    }
}