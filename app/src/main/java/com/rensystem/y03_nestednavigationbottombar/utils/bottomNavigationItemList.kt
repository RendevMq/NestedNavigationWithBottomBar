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

val bottomNavigationItemList = listOf(
    NavigationItem(
        title = "Home",
        route = MainRouteScreen.Home.route,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
    ),
    NavigationItem(
        title = "Profile",
        route = MainRouteScreen.Profile.route,
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
    ),
    NavigationItem(
        title = "Notifications",
        route = MainRouteScreen.Notification.route,
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications,
    ),
    NavigationItem(
        title = "Settings",
        route = MainRouteScreen.Setting.route,
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings,
    )
)
