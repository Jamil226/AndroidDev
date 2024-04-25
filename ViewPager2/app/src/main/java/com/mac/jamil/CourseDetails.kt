package com.mac.jamil

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mac.jamil.databinding.ActivityCoursesBinding
import com.mac.jamil.databinding.ActivityMainBinding

class CourseDetails : AppCompatActivity() {
    private lateinit var mBinding:ActivityCoursesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Course Details"

        mBinding.btnGoBack.setOnClickListener {
            val i = Intent(this, Courses::class.java)
            startActivity(i)
        }

    }
}