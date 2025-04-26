package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rensystem.y03_nestednavigationbottombar.navigation.AuthRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.screens.auth.ForgotPasswordScreen
import com.rensystem.y03_nestednavigationbottombar.screens.auth.LoginScreen
import com.rensystem.y03_nestednavigationbottombar.screens.auth.RegisterScreen

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
    // Aquí estamos creando un sub-gráfico de navegación para las rutas de autenticación
    navigation(
        route = Graph.AuthGraph,
        startDestination = AuthRouteScreen.Login.route
    ){
        composable(route = AuthRouteScreen.Login.route) {
            LoginScreen(navController = rootNavController)
        }
        composable(route = AuthRouteScreen.SignUp.route) {
            RegisterScreen(navController = rootNavController)
        }
        composable(route = AuthRouteScreen.Forget.route) {
            ForgotPasswordScreen(navController = rootNavController)
        }
    }
}