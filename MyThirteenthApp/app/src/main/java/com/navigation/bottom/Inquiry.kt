package com.navigation.bottom

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.navigation.bottom.databinding.ActivityInquiryBinding

class Inquiry : AppCompatActivity() {
    private lateinit var binding:ActivityInquiryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInquiryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowCustomDialog.setOnClickListener {
            val message:String = "Are You Sure to Perform this Action?"
            showCustomDialog(message)
        }

        binding.btnShowDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(R.string.dialogTitle)
            builder.setMessage(R.string.dialogMessage)
            builder.setIcon(R.drawable.ic_alert)

            builder.setPositiveButton("Yes"){_, _ ->

                Toast.makeText(applicationContext,"Clicked Save",Toast.LENGTH_LONG).show()
            }
            //performing cancel action
            builder.setNeutralButton("Cancel"){_ , _ ->
                Toast.makeText(applicationContext,"clicked cancel\n operation cancel",Toast.LENGTH_LONG).show()
            }

            builder.setNegativeButton("No"){_, _ ->
                Toast.makeText(applicationContext,"clicked Cancel",Toast.LENGTH_LONG).show()
            }



            val alertDialog: AlertDialog = builder.create()

            alertDialog.setCancelable(false)
            alertDialog.show()
            val negativeButton = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE)
            negativeButton.setTextColor(Color.GREEN)

            val positiveButton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE)
            positiveButton.setTextColor(Color.RED)


        }


    }

    private fun showCustomDialog(message: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.snipped_alert_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage = dialog.findViewById<TextView>(R.id.custom_dialog_message)
        val btnCancel = dialog.findViewById<Button>(R.id.custom_dialog_cancel)
        val btnSave = dialog.findViewById<Button>(R.id.custom_dialog_save)
        tvMessage.text = message
        btnSave.setOnClickListener {
            Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_LONG).show()

        }
        btnCancel.setOnClickListener {
            Toast.makeText(this, "Data Not Saved", Toast.LENGTH_LONG).show()
        }

    }
}