package com.mac.jamil.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity(tableName = "categories")
data class Categories(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val name : String,
    val details : String,
    val updatedOn : Date,
    val status : Int

)
