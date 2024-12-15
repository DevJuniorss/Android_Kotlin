package com.example.signinup.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.signinup.ui.screens.HomeScreen
import com.example.signinup.ui.screens.SignIn
import com.example.signinup.ui.screens.SignUp

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "signin") {
        composable("signin") { SignIn(navController) }
        composable("signup") { SignUp(navController) }
        composable("home") { HomeScreen() }
    }
}