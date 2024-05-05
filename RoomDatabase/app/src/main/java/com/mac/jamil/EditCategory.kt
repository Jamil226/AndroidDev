package com.mac.jamil

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mac.jamil.R
import com.mac.jamil.databinding.ActivityEditCategoryBinding

class EditCategory : AppCompatActivity() {
    private lateinit var binding:ActivityEditCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}