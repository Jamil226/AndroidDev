package com.room.project

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.room.project.database.ExpenseDatabase
import com.room.project.databinding.ActivityMainBinding
import com.room.project.entities.Expense
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var database: ExpenseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = ExpenseDatabase.getDatabase(this)


        binding.btnSubmit.setOnClickListener {
            val title = binding.etExpenseTitle.text.toString()
            val details = binding.etExpenseDetails.text.toString()
            val amount = binding.etExpenseAmount.text.toString()
            val eAmount = amount.toLong()

            if(title.equals("")){
                binding.etExpenseTitle.error = "Enter Expense Title"
                binding.etExpenseTitle.requestFocus()

            }
            GlobalScope.launch {
                database.expenseDao()
                    .insertExpense(Expense(0, title, details, eAmount, Date(), 1))
            }
            Toasty.success(this, "Expense Added Successfully!", Toast.LENGTH_SHORT, true).show();
            binding.etExpenseTitle.text.clear()
            binding.etExpenseDetails.text.clear()
            binding.etExpenseAmount.text.clear()

        }

        binding.btnView.setOnClickListener {
            database.expenseDao().getExpenses().observe(this, Observer{
                Log.d("Expenses", it.toString())
            })
        }




    }
}