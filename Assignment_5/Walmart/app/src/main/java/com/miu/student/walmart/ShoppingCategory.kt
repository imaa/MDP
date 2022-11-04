package com.miu.student.walmart

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
            R.id.electronics -> Toast.makeText(
                this,
                "You have chosen the Electronics category of shopping",
                Toast.LENGTH_SHORT
            ).show()
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
}