package com.example.signinapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.signinapp.R
import com.example.signinapp.viewmodel.ForgotPasswordViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmScreen(navController: NavController, viewModel: ForgotPasswordViewModel) {
    val email by viewModel.email.collectAsState()
    val code by viewModel.code.collectAsState()
    val password by viewModel.password.collectAsState()
    var passwordVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Confirmation") },
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
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Nội dung chính
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(30.dp))

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
                    text = "Password Reset Confirmed",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color(0xFF007BFF)
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Your password has been successfully reset",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )

                Spacer(Modifier.height(32.dp))

                OutlinedTextField(
                    value = email,
                    onValueChange = {},
                    label = { Text("Email Address") },
                    singleLine = true,
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF007BFF),
                        unfocusedBorderColor = Color.Gray
                    )
                )

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = code,
                    onValueChange = {},
                    label = { Text("Verification Code") },
                    singleLine = true,
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF007BFF),
                        unfocusedBorderColor = Color.Gray
                    )
                )

                Spacer(Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = {},
                    label = { Text("New Password") },
                    singleLine = true,
                    visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth(),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color(0xFF007BFF),
                        unfocusedBorderColor = Color.Gray
                    ),
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible = !passwordVisible }) {
                            Icon(
                                imageVector = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = if (passwordVisible) "Hide password" else "Show password"
                            )
                        }
                    }
                )
            }

            // Nút ở cuối
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            ) {
                Button(
                    onClick = {
                        navController.navigate("login") {
                            popUpTo("forgot") { inclusive = true }
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF28A745)
                    ),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text("Back to Login", color = Color.White, fontSize = 16.sp)
                }

                Spacer(Modifier.height(12.dp))

                TextButton(
                    onClick = {
                        navController.navigate("forgot") {
                            popUpTo("confirm") { inclusive = true }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Reset Another Password", color = Color(0xFF007BFF))
                }
            }
        }
    }
}
