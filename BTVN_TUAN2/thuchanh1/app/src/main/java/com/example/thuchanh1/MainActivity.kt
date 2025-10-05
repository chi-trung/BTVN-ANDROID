package com.example.thuchanh1
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ view
        val edtName = findViewById<EditText>(R.id.edtName)
        val edtAge = findViewById<EditText>(R.id.edtAge)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        // Xử lý khi bấm nút
        btnCheck.setOnClickListener {
            val name = edtName.text.toString().trim()
            val ageText = edtAge.text.toString().trim()

            // Kiểm tra nhập đủ chưa
            if (name.isEmpty() || ageText.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ họ tên và tuổi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val age = ageText.toIntOrNull()
            if (age == null || age < 0) {
                Toast.makeText(this, "Tuổi không hợp lệ!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Phân loại theo độ tuổi
            val result = when {
                age < 2 -> "Em bé"
                age in 2..6 -> "Trẻ em"
                age in 6..65 -> "Người lớn"
                else -> "Người già"
            }

            // Hiển thị kết quả
            tvResult.text = "$name là $result"
        }
    }
}
