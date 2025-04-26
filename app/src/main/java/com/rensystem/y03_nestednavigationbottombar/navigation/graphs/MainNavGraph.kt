package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.navigation.MainRouteScreen
import com.rensystem.y03_nestednavigationbottombar.screens.main.HomeScreen
import com.rensystem.y03_nestednavigationbottombar.screens.main.NotificationScreen
import com.rensystem.y03_nestednavigationbottombar.screens.main.ProfileScreen
import com.rensystem.y03_nestednavigationbottombar.screens.main.SettingScreen
import androidx.navigation.compose.composable

//MainNavGraph.kt
//Aunque homeNavController es responsable de la navegación dentro de la pantalla principal, algunas pantallas pueden necesitar navegar a otras pantallas dentro del flujo global, por lo que se pasa rootNavController a ciertas pantallas como NotificationScreen o SettingScreen. Esto permite que esas pantallas naveguen fuera de su flujo local si es necesario.
@Composable
fun MainGraph(
    rootNavController: NavHostController,
    homeNavController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = homeNavController,
        route = Graph.MainGraph::class,
        startDestination = MainRouteScreen.Home
    ) {
        composable<MainRouteScreen.Home> {
            HomeScreen(modifier)
        }
        composable<MainRouteScreen.Notification> {
            NotificationScreen(modifier, navController = rootNavController)
        }
        composable<MainRouteScreen.Profile> {
            ProfileScreen(modifier)
        }
        composable<MainRouteScreen.Setting> {
            SettingScreen(modifier, navController = rootNavController)
        }
    }
}