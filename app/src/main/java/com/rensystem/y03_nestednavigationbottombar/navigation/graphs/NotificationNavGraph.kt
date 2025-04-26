package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rensystem.y03_nestednavigationbottombar.navigation.AuthRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.navigation.NotificationRouteScreen
import com.rensystem.y03_nestednavigationbottombar.screens.notification.NotificationDetailScreen

fun NavGraphBuilder.notificationNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.NotificationGraph,
        startDestination = NotificationRouteScreen.NotificationDetail.route
    ){
        composable(route = NotificationRouteScreen.NotificationDetail.route) {
            NotificationDetailScreen(navController = rootNavController)
        }
    }
}