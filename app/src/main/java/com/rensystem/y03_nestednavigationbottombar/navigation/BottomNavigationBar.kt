package com.rensystem.y03_nestednavigationbottombar.navigation

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onClick: (NavigationItem) -> Unit,
) {
    NavigationBar(
//        containerColor = Color.Transparent
    ) {
        items.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(),
                selected = currentRoute == navigationItem.route,
                onClick = { onClick(navigationItem) },
                icon = {
                    BadgedBox(badge = {
                        if (navigationItem.badgeCount != null) {
                            Badge{
                                Text(text = navigationItem.badgeCount.toString())
                            }
                        } else if (navigationItem.hasBadgeDot) {
                            Badge()
                        }
                    }) {
                        Icon(
                            imageVector = if (currentRoute == navigationItem.route) {
                                navigationItem.selectedIcon
                            } else {
                                navigationItem.unselectedIcon
                            },
                            contentDescription = navigationItem.title
                        )
                    }
                },
                label = {
                    Text(text = navigationItem.title)
                },
                alwaysShowLabel = false
            )
        }
    }
}
