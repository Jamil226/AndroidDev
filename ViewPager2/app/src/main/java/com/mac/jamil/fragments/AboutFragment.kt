package com.mac.jamil.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.mac.jamil.Courses
import com.mac.jamil.R
import com.mac.jamil.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private var fBinding:FragmentAboutBinding? = null
    private val binding get() = fBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fBinding = FragmentAboutBinding.inflate(inflater, container, false)

        binding?.btnCourses?.setOnClickListener {
            val i = Intent(activity, Courses::class.java)
            startActivity(i)

            Toast.makeText(activity, "About", Toast.LENGTH_LONG).show()
        }
        return binding?.root


    }



}