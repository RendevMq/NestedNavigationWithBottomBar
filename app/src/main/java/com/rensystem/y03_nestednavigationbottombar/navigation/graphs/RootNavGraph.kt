package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.screens.main.MainScreen

//Root

@Composable
fun RootNavGraph(isAuth: Boolean) {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        route = Graph.RootGraph::class, // IMPORTANTE: ahora con ::class
        startDestination = if (isAuth) Graph.MainGraph else Graph.AuthGraph
    ) {
        authNavGraph(rootNavController)

        composable<Graph.MainGraph> {
            MainScreen(rootNavHostController = rootNavController)
        }

        notificationNavGraph(rootNavController)
        settingNavGraph(rootNavController)
    }
}