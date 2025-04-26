package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.navigation.SettingRouteScreen
import com.rensystem.y03_nestednavigationbottombar.screens.setting.SettingDetailScreen

//SettingNavGraph.kt
fun NavGraphBuilder.settingNavGraph(rootNavController: NavHostController) {
    navigation<Graph.SettingGraph>(startDestination = SettingRouteScreen.SettingDetail) {
        composable<SettingRouteScreen.SettingDetail> {
            SettingDetailScreen(rootNavController = rootNavController)
        }
    }
}