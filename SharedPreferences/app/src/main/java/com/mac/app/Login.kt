package com.mac.app


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mac.app.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
//    private  val  loginStatus:Int = 1;
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//          App Debugging
//          Code Inspection
//          Shared Preferences
//          APK Generation

        val sharedPrefs = getSharedPreferences("loginInfo", MODE_PRIVATE)
        val editor = sharedPrefs.edit()


        binding.btnLogin.setOnClickListener{
            val username:String = binding.etUsername.text.toString().trim()

//            val password:String = binding.etPassword.text.toString()
//            binding.etPassword.setText("")
//            Toast.makeText(this, username + " " + password, Toast.LENGTH_SHORT).show()


            editor.apply {
                putString("username", username)
                putInt("loginStatus", 1)
                editor.apply()
            }
            val  i = Intent(this, MainActivity::class.java)
            startActivity(i)



        }

    }
}