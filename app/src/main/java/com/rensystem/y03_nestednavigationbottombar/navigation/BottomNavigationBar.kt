package com.rensystem.y03_nestednavigationbottombar.navigation

import android.util.Log
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//BottomNavigationBar.kt
@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onClick: (NavigationItem) -> Unit,
) {
    Log.i("Renato", currentRoute?:"")
    NavigationBar(
//        containerColor = Color.Red
    ) {
        items.forEach { navigationItem ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(),
                selected = navigationItem.route::class.simpleName == currentRoute,
                onClick = { onClick(navigationItem) },
                icon = {
                    BadgedBox(
                        badge = {
                            when {
                                navigationItem.badgeCount != null -> {
                                    Badge {
                                        Text(text = navigationItem.badgeCount.toString())
                                    }
                                }
                                navigationItem.hasBadgeDot -> {
                                    Badge()
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (navigationItem.route::class.simpleName == currentRoute) {
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
