package com.example.th2.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.th2.R

@Composable
fun BottomButtons(
    showBack: Boolean = false,
    onBackClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    nextText: String = "Next"
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (showBack) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(Color(0xFF6A4C9C), shape = CircleShape)
                        .clickable { onBackClick() },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back),
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }
            } else {
                Spacer(modifier = Modifier.width(56.dp))
            }

            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp)
                    .padding(start = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6A4C9C)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = nextText, color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
