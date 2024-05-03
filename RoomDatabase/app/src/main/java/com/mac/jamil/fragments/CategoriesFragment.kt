package com.mac.jamil.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mac.jamil.adapters.CategoryAdapter
import com.mac.jamil.database.InventoryDatabase
import com.mac.jamil.databinding.FragmentCategoriesBinding


class CategoriesFragment : Fragment() {

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var database: InventoryDatabase

    private var _binding: FragmentCategoriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = InventoryDatabase.getDatabase(requireContext().applicationContext)

        // Initialize RecyclerView and Adapter
        categoryAdapter = CategoryAdapter(requireContext(), emptyList())
        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = categoryAdapter
        }

        database.categoriesDao().getCategories().observe(viewLifecycleOwner) { categories ->
//            categoryAdapter.updateCategories(categories)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}