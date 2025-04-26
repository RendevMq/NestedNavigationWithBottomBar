package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.navigation.NotificationRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.SettingRouteScreen
import com.rensystem.y03_nestednavigationbottombar.screens.setting.SettingDetailScreen

fun NavGraphBuilder.settingNavGraph(rootNavController: NavHostController) {
    // Aquí estamos creando un sub-gráfico de navegación para las rutas de Setting
    navigation(
        route = Graph.SettingGraph,
        startDestination = SettingRouteScreen.SettingDetail.route
    ){
        composable(route = SettingRouteScreen.SettingDetail.route) {
            SettingDetailScreen(rootNavController = rootNavController)
        }
    }
}