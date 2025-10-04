package com.example.thuchanh2

import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtSoLuong = findViewById<EditText>(R.id.edtSoLuong)
        val btnTao = findViewById<MaterialButton>(R.id.btnTao)
        val tvError = findViewById<TextView>(R.id.tvError)
        val layoutButtons = findViewById<LinearLayout>(R.id.layoutButtons)

        btnTao.setOnClickListener {
            val soLuongText = edtSoLuong.text.toString()

            tvError.visibility = TextView.GONE
            layoutButtons.removeAllViews()

            try {
                val soLuong = soLuongText.toInt()

                if (soLuong <= 0) {
                    tvError.text = "Số lượng phải lớn hơn 0"
                    tvError.visibility = TextView.VISIBLE
                } else if (soLuong > 10) {   // 👈 Giới hạn ở đây
                    tvError.text = "Số lượng phải nhỏ hơn 10"
                    tvError.visibility = TextView.VISIBLE
                } else {
                    // Tạo nút như cũ
                    for (i in 1..soLuong) {
                        val btn = MaterialButton(this).apply {
                            text = i.toString()
                            setBackgroundColor(resources.getColor(android.R.color.holo_red_light))
                            val params = LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                            )
                            params.setMargins(20, 10, 20, 10)
                            layoutParams = params
                        }
                        layoutButtons.addView(btn)
                    }
                }
            } catch (e: NumberFormatException) {
                tvError.text = "Dữ liệu bạn nhập không hợp lệ"
                tvError.visibility = TextView.VISIBLE
            }
        }

    }
}
