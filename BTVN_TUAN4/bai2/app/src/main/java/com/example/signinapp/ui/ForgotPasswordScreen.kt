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
fun ForgotPasswordScreen(navController: NavController, viewModel: ForgotPasswordViewModel) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var errorMessage by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Forgot Password") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
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

            Text(
                text = "Forgot Password?",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFF007BFF)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Enter your email address and we'll send you a verification code to reset your password",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                lineHeight = 20.sp
            )

            Spacer(Modifier.height(24.dp))

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    errorMessage = ""
                },
                label = { Text("Email Address") },
                singleLine = true,
                isError = errorMessage.isNotEmpty(),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF007BFF),
                    unfocusedBorderColor = Color.Gray
                ),
                placeholder = { Text("Enter your email") }
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

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    val trimmedEmail = email.text.trim()
                    when {
                        trimmedEmail.isEmpty() -> errorMessage = "Email is required."
                        !trimmedEmail.contains("@") -> errorMessage = "Please enter a valid email address."
                        else -> {
                            errorMessage = ""
                            viewModel.setEmail(trimmedEmail)
                            navController.navigate("verify")
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
                Text("Send Verification Code", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}