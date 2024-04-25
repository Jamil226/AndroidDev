package com.mac.jamil.adapter;


import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mac.jamil.ProductDetails
import com.mac.jamil.R

class ProductsAdapter(private val dataSet: ArrayList<String>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardView: CardView = view.findViewById(R.id.cv_products)
        val name: TextView = view.findViewById(R.id.tv_product_name)
        val distance: TextView = view.findViewById(R.id.tv_product_distance)
        val rating: TextView = view.findViewById(R.id.tv_rating)
        val price: TextView = view.findViewById(R.id.tv_product_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.snipped_products, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val startIndex = position * 4

        val productName = dataSet[startIndex]
        val productDistance = dataSet[startIndex + 1]
        val productRating = dataSet[startIndex + 2]
        val productPrice = dataSet[startIndex + 3]

        holder.name.text = productName
        holder.distance.text = productDistance
        holder.rating.text = productRating
        holder.price.text = productPrice

        // Apply alternate background color
        if (position % 2 == 0) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#303030"))
            holder.name.setTextColor(Color.parseColor("#FFFFFF"))
            holder.distance.setTextColor(Color.parseColor("#FFFFFF"))
            holder.rating.setTextColor(Color.parseColor("#FFFFFF"))
            holder.price.setTextColor(Color.parseColor("#FFFFFF"))
        } else {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            holder.name.setTextColor(Color.parseColor("#000000"))
            holder.distance.setTextColor(Color.parseColor("#000000"))
            holder.rating.setTextColor(Color.parseColor("#000000"))
            holder.price.setTextColor(Color.parseColor("#000000"))
        }

        holder.cardView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ProductDetails::class.java)
            val productNameLabel = "Name: "
            val productDistanceLabel = "Distance: "
            val productRatingLabel = "Rating: "
            val productPriceLabel = "Price: "
            intent.putExtra("name", productNameLabel + productName)
            intent.putExtra("distance",productDistanceLabel + productDistance)
            intent.putExtra("rating",productRatingLabel + productRating)
            intent.putExtra("price", productPriceLabel + productPrice)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataSet.size / 4
    }
