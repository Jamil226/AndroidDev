package com.mac.jamil

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.mac.jamil.databinding.ActivityProductDetailsBinding

class ProductDetails : AppCompatActivity() {
    private lateinit var binding:ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Product Details"
        val title = supportActionBar?.title
        val titleColor = Color.WHITE
        if (title != null) {
            val spannableString = SpannableString(title)
            spannableString.setSpan(
                ForegroundColorSpan(titleColor),
                0,
                title.length,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            supportActionBar?.title = spannableString
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        val backDrawable = ContextCompat.getDrawable(this, R.drawable.ic_back_white)
        supportActionBar?.setHomeAsUpIndicator(backDrawable)

        val productName = intent.getStringExtra("name")
        val productRating = intent.getStringExtra("rating")
        val productDistance = intent.getStringExtra("distance")
        val productPrice = intent.getStringExtra("price")

        binding.textViewProductName.text = productName
        binding.textViewProductRating.text = productRating
        binding.textViewProductDistance.text = productDistance
        binding.textViewProductPrice.text = productPrice

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}