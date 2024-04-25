package com.mac.jamil

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mac.jamil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle :Bundle ?=intent.extras
        val username = bundle?.getString("username") // username
        val session = bundle?.getString("session") // 1
        if(session.equals("1")){
            val loginStatus = "isActive"
            binding.tvWelcome.text = username
            Toast.makeText(this, username, Toast.LENGTH_SHORT).show()

        } else {
            val loginStatus = "isNotActive"
            binding.tvWelcome.text = "User not found"
            Toast.makeText(this, username, Toast.LENGTH_SHORT).show()

        }

    }
}