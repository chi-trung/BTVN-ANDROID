package com.example.myapplication

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

private enum class PermissionState {
    LOCATION,
    NOTIFICATION,
    CAMERA,
    NONE
}

@Composable
fun MainScreen() {
    var permissionState by remember { mutableStateOf(PermissionState.LOCATION) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray) // Placeholder for background image
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 48.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /* TODO: Handle Login */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE55B39))
            ) {
                Text("Login", modifier = Modifier.padding(vertical = 8.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            TextButton(onClick = { /* TODO: Handle Continue without account */ }) {
                Text(
                    "Continue without account",
                    color = Color.White.copy(alpha = 0.7f)
                )
            }
        }

        val onDismiss = {
            permissionState = when (permissionState) {
                PermissionState.LOCATION -> PermissionState.NOTIFICATION
                PermissionState.NOTIFICATION -> PermissionState.CAMERA
                PermissionState.CAMERA -> PermissionState.NONE
                PermissionState.NONE -> PermissionState.NONE
            }
        }

        when (permissionState) {
            PermissionState.LOCATION -> {
                PermissionDialog(
                    icon = R.drawable.location,
                    iconPlaceholderColor = Color(0xFFE3F3E9),
                    title = "Location",
                    description = "Allow maps to access your location while you use the app?",
                    confirmButtonText = "Allow",
                    onConfirm = onDismiss,
                    onDismiss = onDismiss
                )
            }
            PermissionState.NOTIFICATION -> {
                PermissionDialog(
                    icon = R.drawable.notification,
                    iconPlaceholderColor = Color(0xFFFFF9E6),
                    title = "Notification",
                    description = "Please enable notifications to receive updates and reminders",
                    confirmButtonText = "Turn on",
                    onConfirm = onDismiss,
                    onDismiss = onDismiss
                )
            }
            PermissionState.CAMERA -> {
                PermissionDialog(
                    icon = R.drawable.camera,
                    iconPlaceholderColor = Color(0xFFE3F2FD),
                    title = "Camera",
                    description = "We need access to your camera to scan QR codes",
                    confirmButtonText = "Turn on",
                    onConfirm = onDismiss,
                    onDismiss = onDismiss
                )
            }
            PermissionState.NONE -> {
                // Do nothing
            }
        }
    }
}

@Composable
fun PermissionDialog(
    @DrawableRes icon: Int,
    iconPlaceholderColor: Color, // Keep for background color
    title: String,
    description: String,
    confirmButtonText: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        Card(
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier.padding(16.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(iconPlaceholderColor, RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = icon),
                        contentDescription = title,
                        modifier = Modifier.size(60.dp)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = onConfirm,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF96D43))
                ) {
                    Text(confirmButtonText, modifier = Modifier.padding(vertical = 8.dp), color = Color.White)
                }
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedButton(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(50)
                ) {
                    Text("Skip for now", color = Color.Gray, modifier = Modifier.padding(vertical = 8.dp))
                }
            }
        }
    }
}