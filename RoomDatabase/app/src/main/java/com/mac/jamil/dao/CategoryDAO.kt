package com.mac.jamil.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mac.jamil.entities.Categories

@Dao
interface CategoryDAO {
    @Insert
    suspend fun insertCategory(category: Categories)

    @Update
    suspend fun updateCategory(category: Categories)

    @Delete
    suspend fun deleteCategory(category: Categories)

    @Query("SELECT * FROM  categories")
    fun getCategories() : LiveData<List<Categories>>

}