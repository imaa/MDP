package com.miu.student.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        createAccountButton.setOnClickListener {
            var firstName = firstName.text.toString()
            var lastName = lastName.text.toString()
            var email = email.text.toString()
            var password = password.text.toString()
            if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()) {
                var user = User(firstName, lastName, email, password)
                var intent = Intent(this, MainActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            }else
            {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}