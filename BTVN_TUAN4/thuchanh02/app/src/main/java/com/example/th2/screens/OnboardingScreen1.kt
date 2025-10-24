package com.example.th2.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.th2.R

@Composable
fun OnboardingScreen1(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Ảnh minh họa
        Image(
            painter = painterResource(id = R.drawable.a1),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Nội dung
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Easy Time Management",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "With management based on priority and\ndaily tasks, it will give you convenience in\nmanaging and determining the tasks that\nmust be done first.",
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Nút Next full màn
        Button(
            onClick = { navController.navigate("onboarding2") },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth() // 👉 full chiều ngang
                .height(50.dp)
        ) {
            Text(text = "Next", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
        }
    }
}
