package com.mac.jamil.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "products")
data class Products(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name : String,
    val details : String,
    val categoryID : Int,
    val updatedOn : Date,
    val status : Int

)


