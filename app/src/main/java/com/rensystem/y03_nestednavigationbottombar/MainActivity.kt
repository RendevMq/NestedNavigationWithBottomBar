package com.rensystem.y03_nestednavigationbottombar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rensystem.y03_nestednavigationbottombar.navigation.graphs.RootNavGraph
import com.rensystem.y03_nestednavigationbottombar.ui.theme.Y03_nestedNavigationBottomBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Y03_nestedNavigationBottomBarTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RootNavGraph(false)
                }
            }
        }
    }
}
