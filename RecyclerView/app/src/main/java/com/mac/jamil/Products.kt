package com.mac.jamil;

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mac.jamil.adapter.ProductsAdapter
import com.mac.jamil.databinding.ActivityProductsBinding

class Products : AppCompatActivity() {
    private lateinit var mBinding: ActivityProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setSupportActionBar(mBinding.toolbar)

        supportActionBar?.title = "Products"
        val title = supportActionBar?.title
        val titleColor = Color.WHITE
        if (title != null) {
            val spannableString = SpannableString(title)
            spannableString.setSpan(ForegroundColorSpan(titleColor),
                0,
                title.length,
                Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            supportActionBar?.title = spannableString
        }
        val dataset: ArrayList<String> = ArrayList()
        dataset.add("Pizza")
        dataset.add("4.3 KM")
        dataset.add("4.4")
        dataset.add("Rs. 1200")
        dataset.add("Burger")
        dataset.add("2.5 KM")
        dataset.add("4.2")
        dataset.add("Rs. 800")

        val productAdapter = ProductsAdapter(dataset)

        val recyclerView: RecyclerView = mBinding.recyclerProducts
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.adapter = productAdapter
    }
}
