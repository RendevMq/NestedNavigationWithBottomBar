package com.rensystem.y03_nestednavigationbottombar.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.rensystem.y03_nestednavigationbottombar.navigation.BottomNavigationBar
import com.rensystem.y03_nestednavigationbottombar.navigation.graphs.MainGraph
import com.rensystem.y03_nestednavigationbottombar.utils.bottomNavigationItemList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    rootNavHostController: NavHostController,
    homeNavController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by homeNavController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route?.substringAfterLast('.')

    val topBarTitle by remember(currentRoute) {
        derivedStateOf {
            bottomNavigationItemList
                .firstOrNull { it.route::class.simpleName == currentRoute }
                ?.title ?: bottomNavigationItemList.first().title
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = topBarTitle) }
            )
        },
        bottomBar = {
            BottomNavigationBar(
                items = bottomNavigationItemList,
                currentRoute = currentRoute,
                onClick = { item ->
                    homeNavController.navigate(item.route) {
                        // Navegación segura
                        popUpTo(homeNavController.graph.startDestinationRoute ?: "") {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    ) { innerPadding ->
        MainGraph(
            rootNavController = rootNavHostController,
            homeNavController = homeNavController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}