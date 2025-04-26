package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rensystem.y03_nestednavigationbottombar.navigation.AuthRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.screens.auth.ForgotPasswordScreen
import com.rensystem.y03_nestednavigationbottombar.screens.auth.LoginScreen
import com.rensystem.y03_nestednavigationbottombar.screens.auth.RegisterScreen

//AuthNavGraph.kt
fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
    // Aquí estamos creando un sub-gráfico de navegación para las rutas de autenticación
    navigation<Graph.AuthGraph>(startDestination = AuthRouteScreen.Login) {
        composable<AuthRouteScreen.Login> {
            LoginScreen(navController = rootNavController)
        }
        composable<AuthRouteScreen.SignUp> {
            RegisterScreen(navController = rootNavController)
        }
        composable<AuthRouteScreen.ForgotPassword> {
            ForgotPasswordScreen(navController = rootNavController)
        }
    }
}