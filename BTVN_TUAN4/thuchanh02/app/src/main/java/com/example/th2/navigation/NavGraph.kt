package com.example.th2.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.th2.screens.*

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash" // Màn hình khởi động đầu tiên
    ) {
        composable("splash") {
            SplashScreen(navController)
        }

        composable("getStarted") {
            GetStartedScreen(navController)
        }

        composable("onboarding1") {
            OnboardingScreen1(navController)
        }

        composable("onboarding2") {
            OnboardingScreen2(navController)
        }

        composable("onboarding3") {
            OnboardingScreen3(navController)
        }
    }
}
