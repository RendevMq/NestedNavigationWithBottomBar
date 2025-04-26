package com.rensystem.y03_nestednavigationbottombar.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title : String,
    val route: String,
    val selectedIcon : ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadgeDot: Boolean = false,
    val badgeCount: Int? = null
)