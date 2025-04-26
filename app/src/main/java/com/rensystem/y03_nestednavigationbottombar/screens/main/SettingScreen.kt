package com.rensystem.y03_nestednavigationbottombar.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.rensystem.y03_nestednavigationbottombar.navigation.NotificationRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.SettingRouteScreen
import com.rensystem.y03_nestednavigationbottombar.screens.setting.SettingDetailScreen

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color(0xFF094B45)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Setting Screen",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
        Spacer(Modifier.height(40.dp))

        Button(onClick = {
            navController.navigate(SettingRouteScreen.SettingDetail)

        }) {
            Text("Setting Detail Screen", color = Color.White)
        }
    }
}