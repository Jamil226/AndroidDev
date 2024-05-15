package com.room.project.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Expense")

data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    val expenseName : String,
    val expenseDetails : String,
    val amount : Long,
    val updatedOn : Date,
    val status : Int
)