package com.mac.jamil.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.InvalidationTracker
import com.mac.jamil.R
import com.mac.jamil.database.InventoryDatabase
import com.mac.jamil.databinding.FragmentHomeBinding
import com.mac.jamil.databinding.FragmentSettingsBinding

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var database: InventoryDatabase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = InventoryDatabase.getDatabase(requireContext())
        binding.btnHome.setOnClickListener {
            database.categoriesDao().getCategories().observe(viewLifecycleOwner) { categories ->
                binding.tvHome.text = categories.toString()
                Log.d("Categories", categories.toString())
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}