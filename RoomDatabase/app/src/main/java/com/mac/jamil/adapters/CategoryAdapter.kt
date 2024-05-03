package com.mac.jamil.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mac.jamil.EditCategory
import com.mac.jamil.R
import com.mac.jamil.entities.Categories

class CategoryAdapter(private val context: Context, private var categories: List<String>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.snipped_categories, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val cardView: CardView = itemView.findViewById(R.id.cv_categories)
        private val categoryName: TextView = itemView.findViewById(R.id.tv_category)

        fun bind(category: String) {
            categoryName.text = category

            cardView.setOnClickListener {
                val intent = Intent(context, EditCategory::class.java)
                intent.putExtra("CATEGORY_NAME", category)
                context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

}
