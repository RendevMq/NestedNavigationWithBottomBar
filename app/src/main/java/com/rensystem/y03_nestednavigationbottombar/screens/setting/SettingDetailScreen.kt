package com.rensystem.y03_nestednavigationbottombar.screens.setting

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
import com.rensystem.y03_nestednavigationbottombar.navigation.AuthRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph

@Composable
fun SettingDetailScreen(
    modifier: Modifier = Modifier,
    rootNavController: NavController
) {
    Column(
        modifier
            .fillMaxSize()
            .background(Color(0xFF522A0F)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Setting Detail Screen",
            style = MaterialTheme.typography.titleLarge,
            color = Color.White
        )
        Spacer(Modifier.height(40.dp))
        Button(onClick = {
            rootNavController.navigate(AuthRouteScreen.Login){
                popUpTo(Graph.MainGraph){
                    inclusive=true
                }
                launchSingleTop = true
            }
        }) {
            Text("Back to Log in", color = Color.White)
        }
    }
}