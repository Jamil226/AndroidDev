package com.jamil.app

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jamil.app.databinding.ActivityLoginBinding
import com.jamil.app.databinding.ActivitySignUpBinding

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            Toast.makeText(this, "Login Success", Toast.LENGTH_LONG).show()
            val i = Intent(this, SignUp::class.java)
            startActivity(i)
        }
    }
}