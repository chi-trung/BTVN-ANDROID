package com.example.signinapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.signinapp.R
import com.example.signinapp.viewmodel.ForgotPasswordViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNewPasswordScreen(navController: NavController, viewModel: ForgotPasswordViewModel) {
    var password by remember { mutableStateOf(TextFieldValue("")) }
    var confirmPassword by remember { mutableStateOf(TextFieldValue("")) }
    var errorMessage by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Create New Password") },
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
                text = "Create Secure Password",
                style = MaterialTheme.typography.headlineSmall,
                color = Color(0xFF007BFF)
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Create a strong password that is different from your previous passwords",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                lineHeight = 20.sp
            )

            Spacer(Modifier.height(24.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    errorMessage = ""
                },
                label = { Text("New Password") },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                isError = errorMessage.isNotEmpty(),
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
                },
                placeholder = { Text("Enter at least 6 characters") }
            )

            Spacer(Modifier.height(12.dp))

            OutlinedTextField(
                value = confirmPassword,
                onValueChange = {
                    confirmPassword = it
                    errorMessage = ""
                },
                label = { Text("Confirm Password") },
                visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                singleLine = true,
                isError = errorMessage.isNotEmpty(),
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFF007BFF),
                    unfocusedBorderColor = Color.Gray
                ),
                trailingIcon = {
                    IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
                        Icon(
                            imageVector = if (confirmPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (confirmPasswordVisible) "Hide password" else "Show password"
                        )
                    }
                },
                placeholder = { Text("Re-enter your password") }
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

            PasswordRequirementsInfo(password.text)

            Spacer(Modifier.height(24.dp))

            Button(
                onClick = {
                    val pass = password.text.trim()
                    val confirm = confirmPassword.text.trim()

                    when {
                        pass.isEmpty() || confirm.isEmpty() -> {
                            errorMessage = "Please fill in both password fields."
                        }
                        pass.length < 6 -> {
                            errorMessage = "Password must be at least 6 characters long."
                        }
                        pass != confirm -> {
                            errorMessage = "Passwords do not match. Please try again."
                        }
                        else -> {
                            errorMessage = ""
                            viewModel.setPassword(pass)
                            navController.navigate("confirm")
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
                Text("Reset Password", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun PasswordRequirementsInfo(password: String) {
    val requirements = listOf(
        "At least 6 characters" to (password.length >= 6),
        "Contains letters and numbers" to (password.any { it.isLetter() } && password.any { it.isDigit() })
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = "Password Requirements:",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray
        )

        requirements.forEach { (requirement, met) ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = if (met) "✓" else "•",
                    color = if (met) Color(0xFF28A745) else Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(Modifier.width(8.dp))
                Text(
                    text = requirement,
                    style = MaterialTheme.typography.labelSmall,
                    color = if (met) Color(0xFF28A745) else Color.Gray
                )
            }
        }
    }
}