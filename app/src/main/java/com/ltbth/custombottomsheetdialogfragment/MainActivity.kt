package com.ltbth.custombottomsheetdialogfragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //    private lateinit var btnNoThanks: Button
//    private lateinit var btnSendFeedback: Button
//    private lateinit var edtFeedback: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.btn1)
        val button2: Button = findViewById(R.id.btn2)

        button1.setOnClickListener {
            openDialog(Gravity.CENTER)
        }

        button2.setOnClickListener {
            openDialog(Gravity.BOTTOM)
        }
    }

    private fun openDialog(gravity: Int) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.layout_dialog_feedback)

        val window = dialog.window
        window?.let {
            it.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
            it.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            it.attributes.gravity = gravity
        }
        if (gravity == Gravity.CENTER) {
            dialog.setCancelable(false)
        } else {
            dialog.setCancelable(true)
        }
        val edtFeedback = dialog.findViewById<EditText>(R.id.edt_feedback)
        val btnNoThanks = dialog.findViewById<Button>(R.id.btn_nothanks)
        val btnSendFeedback = dialog.findViewById<Button>(R.id.btn_send)

        btnNoThanks.setOnClickListener {
            dialog.dismiss()
        }

        btnSendFeedback.setOnClickListener {
            Toast.makeText(this@MainActivity,"Send feedback",Toast.LENGTH_SHORT).show()
        }
        dialog.show()
    }
}