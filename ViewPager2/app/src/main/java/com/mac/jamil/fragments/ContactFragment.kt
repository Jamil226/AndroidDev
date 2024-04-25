package com.mac.jamil.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mac.jamil.R
import com.mac.jamil.databinding.FragmentAboutBinding
import com.mac.jamil.databinding.FragmentContactBinding


class ContactFragment : Fragment() {
    private var fBinding: FragmentContactBinding? = null
    private val binding get() = fBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fBinding = FragmentContactBinding.inflate(inflater, container, false)

    return binding?.root
    }

}