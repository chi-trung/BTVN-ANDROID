package com.example.thuchanh3

import android.os.Bundle
import android.text.InputType
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val txtError = findViewById<TextView>(R.id.txtError)
        val txtSuccess = findViewById<TextView>(R.id.txtSuccess)
        val btnCheck = findViewById<Button>(R.id.btnCheck)

        txtError.visibility = View.GONE
        txtSuccess.visibility = View.GONE

        btnCheck.setOnClickListener {
            val emailText = edtEmail.text.toString().trim()
            if (emailText.isEmpty()) {
                txtError.text = "Vui lòng nhập email"
                txtError.visibility = View.VISIBLE
                txtSuccess.visibility = View.GONE
                return@setOnClickListener
            }

            if (isValidEmail(emailText)) {
                txtSuccess.visibility = View.VISIBLE
                txtError.visibility = View.GONE
            } else {
                txtError.visibility = View.VISIBLE
                txtSuccess.visibility = View.GONE
            }
        }
    }

    private fun isValidEmail(target: CharSequence?): Boolean {
        return !target.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }
}

