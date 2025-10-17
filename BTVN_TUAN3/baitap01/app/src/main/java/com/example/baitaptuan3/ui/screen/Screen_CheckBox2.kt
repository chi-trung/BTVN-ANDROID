package com.example.baitaptuan3.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.baitaptuan3.R

@Composable
fun Screen_CheckBox2(navController: NavController) {
    // ✅ Đổi nội dung danh sách mới — chủ đề “Sở thích mỗi ngày”
    val items = listOf(
        "Nghe nhạc thư giãn",
        "Uống cà phê buổi sáng",
        "Tập thể dục nhẹ",
        "Đọc sách hoặc truyện",
        "Xem phim yêu thích",
        "Đi dạo buổi tối"
    )

    val checkState = remember { mutableStateListOf(*Array(items.size) { false }) }
    val allCheck = checkState.all { it }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // 🔹 Thanh tiêu đề
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "Icon",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(20.dp)
                    .clickable { navController.popBackStack() }
            )

            Text(
                text = "Danh sách sở thích",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF87C9E1),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        // 🔹 Checkbox “Chọn tất cả”
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 10.dp)
        ) {
            Image(
                painter = if (allCheck)
                    painterResource(id = R.drawable.allcheck)
                else
                    painterResource(id = R.drawable.unallcheck),
                contentDescription = "icon",
                modifier = Modifier
                    .clickable {
                        val newState = !allCheck
                        for (i in checkState.indices) {
                            checkState[i] = newState
                        }
                    }
                    .size(22.dp)
            )

            Text(
                text = "Chọn tất cả",
                fontSize = 22.sp,
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // 🔹 Danh sách từng checkbox
        items.forEachIndexed { index, item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
                    .padding(vertical = 20.dp)
                    .padding(start = 35.dp)
            ) {
                Image(
                    painter = if (checkState[index])
                        painterResource(R.drawable.checkbox_icon)
                    else
                        painterResource(R.drawable.uncheckbox_icon),
                    contentDescription = "Icon",
                    modifier = Modifier
                        .clickable { checkState[index] = !checkState[index] }
                        .size(22.dp)
                )

                Text(
                    text = item,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Screen_CheckBox2Preview() {
    Screen_CheckBox2(navController = rememberNavController())
}
