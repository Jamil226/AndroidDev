package com.mac.jamil

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.mac.jamil.databinding.ActivityTasbeehCounterBinding

class TasbeehCounter : AppCompatActivity() {
    private lateinit var binding:ActivityTasbeehCounterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTasbeehCounterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            countValue()
        }

        binding.btnFreeze.setOnClickListener {
            freezeApp()
        }


    }
    private fun countValue(){
        binding.tvCounterLabel.text = (binding.tvCounterLabel.text.toString().toInt() + 1).toString()
    }

    private fun freezeApp(){
        for (i in 1..10000000000000){
            Log.d("Output", "This is Testing",null)

        }
    }

}