package com.mac.app

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.mac.app.databinding.ActivityMainBinding
import com.mac.app.databinding.ActivitySignUpBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPrefs = getSharedPreferences("loginInfo", MODE_PRIVATE)
        val username = sharedPrefs.getString("username", "")
        val loginStatus = sharedPrefs.getInt("loginStatus", 0)

        if (loginStatus == 1 && !username.equals("")){
            binding.etUsername.setText(username)
            Toast.makeText(this, username, Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "You are not logged in!", Toast.LENGTH_LONG).show()
        }

    }
}