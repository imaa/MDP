package com.miu.student.mycv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.miu.student.mycv.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var  data =getSharedPreferences("login", MODE_PRIVATE)
        var  editor = data.edit()
        editor.putString("username", "admin")
        editor.putString("password", "admin")
        editor.apply()
        binding.signIn.setOnClickListener{
            var username = binding.username.text.toString()
            var password = binding.password.text.toString()
            var data = getSharedPreferences("login", MODE_PRIVATE)
            var usernameData = data.getString("username", "")
            var passwordData = data.getString("password", "")
            if (username == usernameData && password == passwordData) {
                var intent = android.content.Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                android.widget.Toast.makeText(this, "Invalid username or password", android.widget.Toast.LENGTH_SHORT).show()
            }
        }
    }
}