package com.miu.student.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var users : ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        users = ArrayList<User>()
        users.add(User("John", "Doe", "a@a.com", "a"))
        users.add(User("Jane", "Doe", "b@b.com", "b"))
        users.add(User("John", "Smith", "c@c.com", "c"))
        users.add(User("Jane", "Smith", "d@d.com", "d"))
        users.add(User("John", "Doe", "e@e.com", "e"))
        var newUser = intent.getSerializableExtra("user")
        if (newUser != null) {
            var user = newUser as User
            users.add(user)
            emailEditText.setText(user.email)
        }
        forgetPassword.setOnClickListener {
            var email = emailEditText.text.toString()
            var password = ""
            users.find { it.email == email }?.let {
                password = it.password
            }
            if (password != "") {
                var intent = Intent(Intent.ACTION_SEND)
                intent.putExtra(Intent.EXTRA_EMAIL, email)
                intent.putExtra(Intent.EXTRA_SUBJECT, "Password")
                intent.putExtra(Intent.EXTRA_STREAM, "Your password is $password")
                intent.type = "message/rfc822"
                intent.putExtra(Intent.EXTRA_TITLE, "Send Password by email")
                val chooser = Intent.createChooser(intent, "Send Email")
                startActivity(chooser)
            } else {
                Toast.makeText(this, "Email not found", Toast.LENGTH_SHORT).show()
            }
        }
        signIn.setOnClickListener {
            var email = emailEditText.text.toString()
            var password = passwordEditText.text.toString()

            if (users.any { it.email == email && it.password == password }) {
                var user = users.find { it.email == email && it.password == password }
                var intent = Intent(this, ShoppingCategory::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid credential", Toast.LENGTH_SHORT).show()
            }
        }
        createAccount.setOnClickListener {
            var intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }
}