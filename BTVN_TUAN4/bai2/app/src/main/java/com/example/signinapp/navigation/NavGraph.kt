package com.example.signinapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.signinapp.ui.*
import com.example.signinapp.viewmodel.ForgotPasswordViewModel

@Composable
fun AppNavGraph(navController: NavHostController, viewModel: ForgotPasswordViewModel) {
    NavHost(navController = navController, startDestination = "forgot") {

        composable("forgot") {
            ForgotPasswordScreen(navController, viewModel)
        }

        composable("verify") {
            VerifyCodeScreen(navController, viewModel)
        }

        composable("reset") {
            CreateNewPasswordScreen(navController, viewModel)
        }

        composable("confirm") {
            ConfirmScreen(navController, viewModel)
        }

        composable("login") {
            // This would navigate to your login screen
            // For now, just go back to forgot password
            navController.navigate("forgot") {
                popUpTo("forgot") { inclusive = true }
            }
        }
    }
}