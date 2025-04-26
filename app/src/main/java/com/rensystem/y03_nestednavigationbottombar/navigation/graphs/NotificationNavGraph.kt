package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.navigation.NotificationRouteScreen
import com.rensystem.y03_nestednavigationbottombar.screens.notification.NotificationDetailScreen

//NotificationNavGraph.kt
fun NavGraphBuilder.notificationNavGraph(rootNavController: NavHostController) {
    navigation<Graph.NotificationGraph>(startDestination = NotificationRouteScreen.NotificationDetail) {
        composable<NotificationRouteScreen.NotificationDetail> {
            NotificationDetailScreen(navController = rootNavController)
        }
    }
}