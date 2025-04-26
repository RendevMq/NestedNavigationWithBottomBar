package com.rensystem.y03_nestednavigationbottombar.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.rensystem.y03_nestednavigationbottombar.R
import com.rensystem.y03_nestednavigationbottombar.navigation.AuthRouteScreen
import com.rensystem.y03_nestednavigationbottombar.navigation.Graph

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isLoginEnabled by remember { mutableStateOf(false) }

    // Validación de los campos
    val isEmailValid = email.contains("@") && email.contains(".")
    val isPasswordValid = password.length >= 6

    // Actualizar el estado del botón de Login
    LaunchedEffect(isEmailValid, isPasswordValid) {
        isLoginEnabled = isEmailValid && isPasswordValid
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Imagen de la app (logo o similar)
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .padding(bottom = 16.dp)
        )

        // Título de la pantalla
        Text(
            text = "Login Screen",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Campo de correo electrónico
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth(),
            isError = email.isNotEmpty() && !isEmailValid
        )
        if (email.isNotEmpty() && !isEmailValid) {
            Text(
                text = "Por favor, ingresa un correo válido",
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo de contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            isError = password.isNotEmpty() && !isPasswordValid
        )
        if (password.isNotEmpty() && !isPasswordValid) {
            Text(
                text = "La contraseña debe tener al menos 6 caracteres",
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de login
        Button(
            onClick = {
                navController.navigate(Graph.MainGraph){
                    popUpTo(AuthRouteScreen.Login){
                        inclusive = true
                    }
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = isLoginEnabled
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de "Olvidé mi contraseña"
        TextButton(
            onClick = {
                navController.navigate(AuthRouteScreen.ForgotPassword) // Navegar a la pantalla de recuperación de contraseña
            }
        ) {
            Text(text = "Olvidé mi contraseña", color = MaterialTheme.colorScheme.primary)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón de "Registrarse"
        TextButton(
            onClick = {
                navController.navigate(AuthRouteScreen.SignUp) // Navegar a la pantalla de registro
            }
        ) {
            Text(
                text = "¿No tienes una cuenta? Regístrate",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
