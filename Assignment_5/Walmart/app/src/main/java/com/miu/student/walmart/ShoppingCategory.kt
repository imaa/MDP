package com.miu.student.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
        var user = intent.getSerializableExtra("user") as User
        if (user != null) {
            welcome.text = "Welcome ${user.email} "
        }
    }
    fun imageClick(view: View) {
        when (view.id) {
            R.id.electronics -> {
                var intent = Intent(this, ProductList::class.java)
                intent.putExtra("products", GetElectronicProducts())
                startActivity(intent)
            }
            R.id.clothing -> Toast.makeText(
                this,
                "You have chosen the Clothing category of shopping",
                Toast.LENGTH_SHORT
            ).show()
            R.id.food -> Toast.makeText(
                this,
                "You have chosen the Food category of shopping",
                Toast.LENGTH_SHORT
            ).show()
            R.id.beauty -> Toast.makeText(
                this,
                "You have chosen the Beauty category of shopping",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
    fun GetElectronicProducts():ArrayList<Product>
    { var products : ArrayList<Product>
        products = ArrayList<Product>()
        products.add(Product("Laptop", 1000.0, "Black", R.drawable.laptop, "1", "Laptop"))
        products.add(Product("IPAD", 2000.0, "Black", R.drawable.ipad, "2", "IPAD"))
        products.add(Product("IPHONE", 3000.0, "Black", R.drawable.ipone, "3", "IPHONE"))
        products.add(Product("MAC Book Pro", 4000.0, "Black", R.drawable.macpro, "4", "MAC Book Pro"))
        products.add(Product("Samsung S10", 5000.0, "Black", R.drawable.samsung, "5", "Samsung S10"))
        return  products
    }
}