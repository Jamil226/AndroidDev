package com.room.project.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.room.project.convertors.Convertors
import com.room.project.dao.ExpenseDao
import com.room.project.entities.Expense


@Database(
    entities = [Expense::class],
    version = 1
)
@TypeConverters(Convertors::class)
abstract class ExpenseDatabase : RoomDatabase() {

    abstract fun expenseDao() : ExpenseDao

    companion object {

        @Volatile
        private var INSTANCE : ExpenseDatabase? = null

        fun getDatabase(context: Context) : ExpenseDatabase {
            if(INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder (
                        context.applicationContext,
                        ExpenseDatabase::class.java,
                        "expense_db")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }


}