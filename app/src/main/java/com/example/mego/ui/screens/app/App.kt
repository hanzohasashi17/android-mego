package com.example.mego.ui.screens.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mego.ui.screens.home.ui.HomeScreen
import com.example.mego.ui.screens.onboarding.ui.OnboardingScreen

@Composable
fun App() {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = OnboardingScreen
        ) {
            composable<HomeScreen> {
                HomeScreen()
            }
            composable<OnboardingScreen> {
                OnboardingScreen()
            }
        }
    }
}