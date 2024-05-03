package com.mac.jamil.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mac.jamil.entities.Categories
import com.mac.jamil.entities.Products


@Dao
interface ProductsDAO {

    @Insert
    suspend fun insertProduct(products: Products)

    @Update
    suspend fun updateProduct(products: Products)

    @Delete
    suspend fun deleteProduct(products: Products)

    @Query("SELECT * FROM  products")
    fun getProducts() : LiveData<List<Products>>

}