package com.example.baitaptuan3.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaptuan3.R

@Composable
fun Screen_CheckBox(navController: NavController) {
    // 🔄 Danh sách mới — đồ vật hiện đại
    val items = listOf(
        "Điện thoại",
        "Máy tính xách tay",
        "Máy tính bảng",
        "Tai nghe",
        "Chuột máy tính",
        "Bàn phím",
        "Tivi",
        "Máy ảnh",
        "Máy in",
        "Loa bluetooth"
    )

    val checkState = remember { mutableStateListOf(*Array(items.size) { false }) }
    val allCheck = checkState.all { it }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ====== Thanh tiêu đề ======
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(24.dp)
                    .clickable { navController.popBackStack() }
            )
            Text(
                text = "Checkbox",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF87C9E1),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(80.dp))

        // ====== Checkbox "Chọn tất cả" ======
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.align(Alignment.Start)
        ) {
            Checkbox(
                checked = allCheck,
                onCheckedChange = { isChecked ->
                    for (i in checkState.indices) {
                        checkState[i] = isChecked
                    }
                }
            )
            Text(
                text = "Chọn tất cả",
                fontSize = 20.sp,
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // ====== Danh sách các checkbox ======
        items.forEachIndexed { index, item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
                    .padding(vertical = 6.dp)
                    .padding(start = 25.dp)
            ) {
                Checkbox(
                    checked = checkState[index],
                    onCheckedChange = { checkState[index] = it }
                )
                Text(item, fontSize = 18.sp)
            }
        }
    }
}
