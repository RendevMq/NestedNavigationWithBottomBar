package com.rensystem.y03_nestednavigationbottombar.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import com.rensystem.y03_nestednavigationbottombar.navigation.MainRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.NavigationItem
import androidx.navigation.NavBackStackEntry

//Funcion de extension para extraer el último pedazo del route
fun NavBackStackEntry?.simpleRoute(): String? {
    return this?.destination?.route?.substringAfterLast('.')
}

//bottomNavigationItemList.kt
val bottomNavigationItemList = listOf(
    NavigationItem(
        title = "Home",
        route = MainRouteScreen.Home, // Ahora pasamos el objeto, no un String
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
    ),
    NavigationItem(
        title = "Profile",
        route = MainRouteScreen.Profile,
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
    ),
    NavigationItem(
        title = "Notifications",
        route = MainRouteScreen.Notification,
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
    ),
    NavigationItem(
        title = "Settings",
        route = MainRouteScreen.Setting,
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
    )
)

