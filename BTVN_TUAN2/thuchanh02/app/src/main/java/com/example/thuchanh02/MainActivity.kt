package com.example.thuchanh02

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var edtSoLuong: EditText
    private lateinit var btnTao: MaterialButton
    private lateinit var tvError: TextView
    private lateinit var layoutButtons: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ view
        edtSoLuong = findViewById(R.id.edtSoLuong)
        btnTao = findViewById(R.id.btnTao)
        tvError = findViewById(R.id.tvError)
        layoutButtons = findViewById(R.id.layoutButtons)

        btnTao.setOnClickListener {
            val input = edtSoLuong.text.toString().trim()

            // Ẩn thông báo lỗi trước đó
            tvError.visibility = View.GONE
            layoutButtons.removeAllViews()

            // Kiểm tra dữ liệu nhập
            if (TextUtils.isEmpty(input)) {
                showError("Vui lòng nhập số lượng!")
                return@setOnClickListener
            }

            val number = input.toIntOrNull()
            if (number == null || number <= 0) {
                showError("Dữ liệu bạn nhập không hợp lệ")
                return@setOnClickListener
            }

            // Tạo các button động
            createButtons(number)
        }
    }

    private fun showError(message: String) {
        tvError.text = message
        tvError.visibility = View.VISIBLE
    }

    private fun createButtons(count: Int) {
        for (i in 1..count) {
            val button = Button(this)
            button.text = i.toString()
            button.setBackgroundColor(resources.getColor(android.R.color.holo_red_light))
            button.setTextColor(resources.getColor(android.R.color.white))
            button.textSize = 18f
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(60, 15, 60, 0)
            button.layoutParams = params
            button.background = resources.getDrawable(R.drawable.rounded_red_button, null)
            layoutButtons.addView(button)
        }
    }
}
