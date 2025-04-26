package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.navigation.MainRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.NotificationRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.SettingRouteScreen
import com.rensystem.y03_nestednavigationbottombar.screens.main.HomeScreen
import com.rensystem.y03_nestednavigationbottombar.screens.main.NotificationScreen
import com.rensystem.y03_nestednavigationbottombar.screens.main.ProfileScreen
import com.rensystem.y03_nestednavigationbottombar.screens.main.SettingScreen

//Aunque homeNavController es responsable de la navegación dentro de la pantalla principal, algunas pantallas pueden necesitar navegar a otras pantallas dentro del flujo global, por lo que se pasa rootNavController a ciertas pantallas como NotificationScreen o SettingScreen. Esto permite que esas pantallas naveguen fuera de su flujo local si es necesario.
@Composable
fun MainGraph(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = homeNavController,
        route = Graph.MainScreenGraph,
        startDestination = MainRouteScreen.Home.route
    ) {
        composable(route = MainRouteScreen.Home.route) {
            HomeScreen(modifier)
        }
        composable(route = MainRouteScreen.Notification.route) {

            NotificationScreen(modifier, navController = rootNavController)
        }
        composable(route = MainRouteScreen.Profile.route) {

            ProfileScreen(modifier)
        }
        composable(route = MainRouteScreen.Setting.route) {

            SettingScreen(modifier, navController = rootNavController)
        }
    }
}