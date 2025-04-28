package com.rensystem.y03_nestednavigationbottombar.navigation.graphs

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph
import com.rensystem.y03_nestednavigationbottombar.screens.main.MainScreen

//Root

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun RootNavGraph(isAuth: Boolean) {
    val rootNavController = rememberNavController()
    //Cuando usas SharedTransitionLayout directamente con NavHost, NavHost ya administra internamente la transición usando AnimatedContent
    //No se necesita escribir AnimatedContent {} manualmente como antes cuando no había navegación
    SharedTransitionLayout {
        NavHost(
            navController = rootNavController,
            route = Graph.RootGraph::class, // IMPORTANTE: ahora con ::class
            startDestination = if (isAuth) Graph.MainGraph else Graph.AuthGraph
        ) {
            authNavGraph(rootNavController)
            composable<Graph.MainGraph> {
                MainScreen(
                    rootNavHostController = rootNavController,
                    sharedTransitionScope = this@SharedTransitionLayout,
                    animatedContentScope = this@composable,
                )
            }
            profileNavGraph(
                sharedTransitionScope = this@SharedTransitionLayout,
                rootNavController = rootNavController
            )
            notificationNavGraph(rootNavController)
            settingNavGraph(rootNavController)
        }
    }
}