package com.example.signinapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.signinapp.R
import com.example.signinapp.viewmodel.ForgotPasswordViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerifyCodeScreen(navController: NavController, viewModel: ForgotPasswordViewModel) {
    var code by remember { mutableStateOf(TextFieldValue("")) }
    var errorMessage by remember { mutableStateOf("") }
    val email by viewModel.email.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Verify Code") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF007BFF),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(Modifier.height(40.dp))

            // --- Logo ---
            Image(
                painter = painterResource(id = R.drawable.logo_uth),
                contentDescription = "UTH Logo",
                modifier = Modifier
                    .height(80.dp)
                    .width(100.dp)
            )

            Spacer(Modifier.height(20.dp))

            Image(
                painter = painterResource(id = R.drawable.uth_smarttasks),
                contentDescription = "UTH SmartTasks Logo",
                modifier = Modifier
                    .height(100.dp)
                    .width(160.dp)
            )

            Spacer(Modifier.height(32.dp))

            // --- Title ---
            Text(
                text = "Enter Verification Code",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFF007BFF)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "We sent a 6-digit code to $email",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                lineHeight = 20.sp
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = "Please check your email and enter the code below",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )

            Spacer(Modifier.height(24.dp))

            // --- Input Field ---
            OutlinedTextField(
                value = code,
                onValueChange = {
                    if (it.text.length <= 6) {
                        code = it
                        errorMessage = ""
                    }
                },
                label = { Text("Enter 6-digit Code") },
                singleLine = true,
                isError = errorMessage.isNotEmpty(),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF007BFF),
                    unfocusedBorderColor = Color.Gray
                ),
                placeholder = { Text("000000") }
            )

            if (errorMessage.isNotEmpty()) {
                Text(
                    text = errorMessage,
                    color = Color.Red,
                    fontSize = 13.sp,
                    modifier = Modifier
                        .align(Alignment.Start)
                        .padding(top = 4.dp)
                )
            }

            Spacer(Modifier.height(16.dp))

            // --- Resend Code Option ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = { /* Resend code logic */ }) {
                    Text("Resend Code", color = Color(0xFF007BFF))
                }
            }

            Spacer(Modifier.height(24.dp))

            // --- Button ---
            Button(
                onClick = {
                    val trimmedCode = code.text.trim()
                    when {
                        trimmedCode.isEmpty() -> errorMessage = "Verification code is required."
                        trimmedCode.length < 6 -> errorMessage = "Code must be exactly 6 digits."
                        else -> {
                            errorMessage = ""
                            viewModel.setCode(trimmedCode)
                            navController.navigate("reset")
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF007BFF)
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text("Verify & Continue", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}