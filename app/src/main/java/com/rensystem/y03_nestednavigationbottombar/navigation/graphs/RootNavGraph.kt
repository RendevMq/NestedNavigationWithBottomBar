package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.screens.main.MainScreen

@Composable
fun RootNavGraph(isAuth : Boolean) {

    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        route = Graph.RootGraph,
        startDestination = if (isAuth) Graph.MainScreenGraph else Graph.AuthGraph
    ) {
        authNavGraph(rootNavController = rootNavController)
        composable(route = Graph.MainScreenGraph){
            MainScreen(rootNavHostController = rootNavController)
        }
        notificationNavGraph(rootNavController)
        settingNavGraph(rootNavController)
    }
}