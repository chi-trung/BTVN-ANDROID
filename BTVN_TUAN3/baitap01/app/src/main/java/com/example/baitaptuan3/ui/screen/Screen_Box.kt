package com.example.baitaptuan3.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.baitaptuan3.R

@Composable
fun Screen_Box(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // ==== Thanh tiêu đề ====
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.back_icon),
                contentDescription = "Back icon",
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(24.dp)
                    .clickable { navController.popBackStack() }
            )

            Text(
                text = "Box layout",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF87C9E1),
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(100.dp))

        // ==== Avatar 1 ====
        AvatarWithStatus(
            avatarRes = R.drawable.avt1,
            checkIconRes = R.drawable.icon_check
        )

        Spacer(modifier = Modifier.height(50.dp))

        // ==== Avatar 2 ====
        AvatarWithStatus(
            avatarRes = R.drawable.avt2,
            checkIconRes = R.drawable.icon_check
        )
    }
}

@Composable
fun AvatarWithStatus(
    avatarRes: Int,
    checkIconRes: Int,
    avatarSize: Int = 200
) {
    Box(
        modifier = Modifier.size(avatarSize.dp),
        contentAlignment = Alignment.Center
    ) {
        // Avatar tròn
        Image(
            painter = painterResource(id = avatarRes),
            contentDescription = "Avatar",
            modifier = Modifier
                .clip(CircleShape)
                .matchParentSize()
        )

        // Icon trạng thái (đè lên avatar)
        Image(
            painter = painterResource(id = checkIconRes),
            contentDescription = "Status icon",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-20).dp, y = (-20).dp) // 👈 đè lên avatar
                .size(40.dp) // tùy chỉnh kích thước icon
        )
    }
}
