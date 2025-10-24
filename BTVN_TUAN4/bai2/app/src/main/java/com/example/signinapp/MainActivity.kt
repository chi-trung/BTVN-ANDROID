package com.example.signinapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.signinapp.navigation.AppNavGraph
import com.example.signinapp.ui.theme.SigninappTheme
import com.example.signinapp.viewmodel.ForgotPasswordViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SigninappTheme {
                val navController = rememberNavController()
                val viewModel: ForgotPasswordViewModel = viewModel()
                AppNavGraph(navController, viewModel)
            }
        }
    }
}