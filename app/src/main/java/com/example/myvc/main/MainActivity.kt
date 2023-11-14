package com.example.myvc.main

import android.content.Intent
import android.graphics.Color.BLUE
import android.graphics.Color.WHITE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myvc.authentication.LoginActivity
import com.example.myvc.authentication.RegisterActivity
import com.example.myvc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginBtn.setOnClickListener {
            binding.loginBtn.setBackgroundColor(BLUE)
            binding.loginBtn.setTextColor(WHITE)

            startActivity(Intent(this, LoginActivity::class.java))
            Toast.makeText(this, "Please Login", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.registerBtn.setOnClickListener {
            binding.registerBtn.setBackgroundColor(BLUE)
            binding.registerBtn.setTextColor(WHITE)

            startActivity(Intent(this, RegisterActivity::class.java))
            Toast.makeText(this, "Please Register", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}